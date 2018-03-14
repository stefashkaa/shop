package dao;

import java.sql.Connection;
import java.util.Properties;

public abstract class DAO {
    protected String driver = null;
    protected String url = null;
    protected Properties properties = null;

    public DAO(String driver) {
        this.driver = driver;
    }

    protected void registerDriverManager() {
        try {
            Class.forName(driver).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public abstract void setURL(String host, String database, int port);

    public abstract Connection getConnection();

    public void connect(String login, String password) {
        registerDriverManager();
        properties = new Properties();
        properties.setProperty("password", password);
        properties.setProperty("user", login);
        properties.setProperty("useUnicode", "true");
        properties.setProperty("characterEncoding", "utf8");
    }
}