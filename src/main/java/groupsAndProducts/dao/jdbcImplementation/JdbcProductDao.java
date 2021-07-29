package groupsAndProducts.dao.jdbcImplementation;

import groupsAndProducts.dao.ProductDao;
import groupsAndProducts.domain.Group;
import groupsAndProducts.domain.Product;
import groupsAndProducts.utils.DatabaseUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {

    private final int MAX_PRODUCT_COUNT = 10;
    private final int LIMIT = 10;

    @Override
    public List<Product> getAllProductsInGroupByGroupId(Long id, Integer page) {
        List<Product> allProducts = new ArrayList<>();
        int realPageNumber = page - 1;
        int amountToSkip = realPageNumber * MAX_PRODUCT_COUNT;

        try (Connection connection = DatabaseUtils.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM T_PRODUCT WHERE group_id = ? LIMIT ? OFFSET ?");
            preparedStatement.setLong(1, id);
            preparedStatement.setInt(2, LIMIT);
            preparedStatement.setInt(3, amountToSkip);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                try {
                    long currId = Long.parseLong(resultSet.getString("PRODUCT_ID"));
                    String productName = resultSet.getString("PRODUCT_NAME");
                    long groupId = Long.parseLong(resultSet.getString("GROUP_ID"));
                    BigDecimal price = new BigDecimal(resultSet.getString("PRODUCT_PRICE"));

                    allProducts.add(new Product(currId, productName, groupId, price));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allProducts;
    }
}
