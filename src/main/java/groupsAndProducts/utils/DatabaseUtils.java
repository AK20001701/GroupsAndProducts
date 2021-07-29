package groupsAndProducts.utils;

import java.sql.*;

public class DatabaseUtils {
    private static DatabaseUtils instance;

    private static final String URL = "jdbc:postgresql://localhost/hr_test";
    private static final String USER = "postgres";
    private static final String PASSWORD = "qwerty1243";

    private DatabaseUtils() {
    }

    public static DatabaseUtils getInstance() {
        if (instance == null) {
            instance = new DatabaseUtils();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        loadMySQL();
        return  DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private void loadMySQL() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
