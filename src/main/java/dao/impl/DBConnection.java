package dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static DBConnection instance;

    private static Connection connection;

    public DBConnection() {

        connection = null;

        Properties prop = new Properties();
        try {
            prop.load(DBConnection.class.getClassLoader()
                    .getResourceAsStream("/db/db.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static DBConnection getInstance() {
        try {
            if (instance == null || connection.isClosed()) {
                instance = new DBConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
