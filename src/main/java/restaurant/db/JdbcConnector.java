package restaurant.db;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Properties;

public class JdbcConnector {
    private static final Logger log = Logger.getLogger(JdbcConnector.class);
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

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
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            log.warn(e.getMessage());
        }
    }
    public ResultSet readRecords(String sql_stmt) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql_stmt);
            return resultSet;
        }
        catch (SQLException e) {
            log.warn(e.getMessage());
        }
        return resultSet;
    }

    public void executeStatement(String sql_stmt) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql_stmt);
        }
        catch (SQLException e) {
            log.warn(e.getMessage());
        }
    }

    public void executePrepStatement(String sql_stmt, String email){
        try {
            preparedStatement = connection.prepareStatement(sql_stmt);
            preparedStatement.setString(1, email);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            log.info(e.getMessage());
        }
    }

    public void disconnectFromDB() {
        try {
            resultSet.close();
            statement.close();
            preparedStatement.close();
            connection.close();
        }
        catch (Exception e) {
            log.warn(e.getMessage());
        }
    }
}
