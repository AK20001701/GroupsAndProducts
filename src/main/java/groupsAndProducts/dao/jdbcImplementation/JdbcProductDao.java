package groupsAndProducts.dao.jdbcImplementation;

import groupsAndProducts.dao.ProductDao;
import groupsAndProducts.domain.Group;
import groupsAndProducts.domain.Product;
import groupsAndProducts.utils.DatabaseUtils;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {
    public Product get(long id) {
        String sql = "SELECT * FROM child WHERE id =" + id;
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);
        Product product = null;
        try {
            resultSet.next();
            long currId = Long.parseLong(resultSet.getString("PRODUCT_ID"));
            String productName = resultSet.getString("PRODUCT_NAME");
            long groupId = Long.parseLong(resultSet.getString("GROUP_ID"));
            BigDecimal price = new BigDecimal(resultSet.getString("PRODUCT_PRICE"));

            product = new Product(currId, productName, groupId, price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> getAll() {
        List<Product> allProducts = new ArrayList<>();
        String sql = "SELECT * FROM T_GROUP;";
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);

        try {
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
