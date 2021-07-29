package groupsAndProducts.dao.jdbcImplementation;

import groupsAndProducts.dao.GroupDao;
import groupsAndProducts.domain.Group;
import groupsAndProducts.domain.Product;
import groupsAndProducts.utils.DatabaseUtils;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcGroupDao implements GroupDao {
    public Group get(long id) {
        String sql = "SELECT * FROM child WHERE id =" + id;
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);
        Group group = null;
        try {
            resultSet.next();
            long currId = Long.parseLong(resultSet.getString("GROUP_ID"));
            String groupName = resultSet.getString("GROUP_NAME");

            group = new Group(currId, groupName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    public List<Group> getAll() {
        List<Group> allGroups = new ArrayList<>();
        String sql = "SELECT * FROM T_GROUP;";
        ResultSet resultSet = DatabaseUtils.getInstance().query(sql);

        try {
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

        return allGroups;
    }
}
