package by.itacademy.mikhalevich.icourse.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public abstract class AbstractConnection {

    public static final String DB_DRIVER = "db.driver";
    public static final String DB_URL = "db.url";
    public static final String DB_USERNAME = "db.username";
    public static final String DB_PASSWORD = "db.password";
    private final Properties applicationProperties = new Properties();
    private static BasicDataSource dataSource;
    private static Connection connection;

    public AbstractConnection() {
        loadApplicationProperties();
        dataSource = createDataSource();
    }

    public static Connection getConnection() throws SQLException {
        connection = null;
        try {
            connection = dataSource.getConnection();

        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return connection;
    }

    private BasicDataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        //dataSource.setDefaultAutoCommit(false);
        //dataSource.setRollbackOnReturn(true);
        dataSource.setDriverClassName(getApplicationProperty(DB_DRIVER));
        dataSource.setUrl(getApplicationProperty(DB_URL));
        dataSource.setUsername(getApplicationProperty(DB_USERNAME));
        dataSource.setPassword(getApplicationProperty(DB_PASSWORD));
        return dataSource;
    }

    public String getApplicationProperty(String key) {
        return applicationProperties.getProperty(key);
    }

    private void loadApplicationProperties() {
        try (InputStream in = AbstractConnection.class.getClassLoader().getResourceAsStream("application.properties")) {
            applicationProperties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close() {
        try {
            connection.close();
            dataSource.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
