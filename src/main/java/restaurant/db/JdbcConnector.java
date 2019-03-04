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

    public void executePreparedStatement(String sql, String args){
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,args);
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
