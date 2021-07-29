package groupsAndProducts.dao.jdbcImplementation;

import groupsAndProducts.dao.GroupDao;
import groupsAndProducts.domain.Group;
import groupsAndProducts.utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcGroupDao implements GroupDao {

    private final int MAX_GROUP_COUNT = 10;
    private final int LIMIT = 10;

    @Override
    public List<Group> getPage(Integer page) {

        int realPageNumber = page - 1;
        int amountToSkip = realPageNumber * MAX_GROUP_COUNT;
        List<Group> allGroups = new ArrayList<>();

        try (Connection connection = DatabaseUtils.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM T_GROUP LIMIT ? OFFSET ?");
            preparedStatement.setInt(1, LIMIT);
            preparedStatement.setInt(2, amountToSkip);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                try {
                    long currId = Long.parseLong(resultSet.getString("GROUP_ID"));
                    String groupName = resultSet.getString("GROUP_NAME");
                    allGroups.add(new Group(currId, groupName));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        List<Group> allGroups = new ArrayList<>();
//        String sql = "SELECT * FROM T_GROUP" + " LIMIT 10 OFFSET " + (page - 1) * MAX_GROUP_COUNT;
//        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);
//
//        try {
//            while (resultSet.next()) {
//                try {
//                    long currId = Long.parseLong(resultSet.getString("GROUP_ID"));
//                    String groupName = resultSet.getString("GROUP_NAME");
//                    allGroups.add(new Group(currId, groupName));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return allGroups;
    }

    @Override
    public Long getProductsCountById(Long id) {

        try (Connection connection = DatabaseUtils.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM T_PRODUCT WHERE group_id = ?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            return Long.parseLong(resultSet.getString("count"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0L;
    }
}
