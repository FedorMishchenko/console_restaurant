package homework12;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Properties;

public class JdbcConnector {
    private static final Logger log = Logger.getLogger(JdbcConnector.class);
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    JdbcConnector(){
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String username = "root";
            String password = "password";
            Class.forName(driver);
            String dataBaseName = "test";
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
            connection = DriverManager.getConnection(url,properties );
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            log.warn(e.getMessage());
        }
    }
    public ResultSet readRecords(String stmt) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(stmt);
            return resultSet;
        }
        catch (SQLException e) {
            log.warn(e.getMessage());
        }
        return resultSet;
    }

    public void executeStatement(String stmt) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(stmt);
        }
        catch (SQLException e) {
            log.warn(e.getMessage());
        }
    }

    public void disconnectFromDB() {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception e) {
            log.warn(e.getMessage());
        }
    }
}
