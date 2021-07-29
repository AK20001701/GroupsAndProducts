package groupsAndProducts.utils;

import java.sql.*;

public class DatabaseUtils {
    private static DatabaseUtils instance;

    private static final String URL = "jdbc:mysql://vdb2.dataart.net:3306/hr_test";
    private static final String USER = "hr_test";
    private static final String PASSWORD = "12gh56qw";

    private DatabaseUtils() {
    }

    public static DatabaseUtils getInstance() {
        if (instance == null) {
            instance = new DatabaseUtils();
        }
        return instance;
    }

    public ResultSet query(String sql) {
        loadMySQL();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = connection.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void loadMySQL() {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
