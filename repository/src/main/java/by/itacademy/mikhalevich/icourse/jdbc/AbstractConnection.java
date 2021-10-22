package by.itacademy.mikhalevich.icourse.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractConnection {
    private static final String url = "jdbc:postgresql://localhost/icourse";
    private static final String username = "icourseadmin";
    private static final String password = "admin";
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            if(connection == null) {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e);
        }
        return connection;
    }

    public static void close() throws SQLException {
        if(connection != null) {
            connection.close();
        }
    }
}
