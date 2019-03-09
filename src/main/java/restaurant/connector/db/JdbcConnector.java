package restaurant.connector.db;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Properties;

public class JdbcConnector implements Connector{
    private static final Logger log = Logger.getLogger(JdbcConnector.class);
    private Connection connection = null;

    public JdbcConnector(){
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String username = "root";
            String password = "password";
            Class.forName(driver);
            String dataBaseName = "restaurant";
            Properties properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");
            String url = "jdbc:mysql://localhost:3306/"+ dataBaseName +
                    "?verifyServerCertificate=false"+
                    "&useSSL=false"+
                    "&requireSSL=false"+
                    "&useLegacyDatetimeCode=false"+
                    "&amp"+
                    "&serverTimezone=UTC";
            connection = DriverManager.getConnection(url, properties);
            connection.setAutoCommit(true);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            log.warn(e.getMessage());
        }
    }
    @Override
    public Connection getConnection(){
        return this.connection;
    }

}