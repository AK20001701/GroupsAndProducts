package groupsAndProducts.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseUtils {
    private static DatabaseUtils instance;

    private static String URL = "";
    private static String USER = "";
    private static String PASSWORD = "";

    private DatabaseUtils() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("dbConfig");
        URL = resourceBundle.getString("db.url");
        USER = resourceBundle.getString("db.login");
        PASSWORD = resourceBundle.getString("db.password");
    }

    public static DatabaseUtils getInstance() {
        if (instance == null) {
            instance = new DatabaseUtils();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        loadMySQL();
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    private void loadMySQL() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
