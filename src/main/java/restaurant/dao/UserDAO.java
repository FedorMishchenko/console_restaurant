package restaurant.dao;

import restaurant.db.JdbcConnector;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class UserDAO {
    private static final Logger log = Logger.getLogger(UserDAO.class);
    private static SQLScripts script = SQLScripts.getInstance();

    @NotNull
    @Contract(" -> new")
    public static UserDAO getInstance(){
        return new UserDAO();
    }

    public void create(String email){
        JdbcConnector connector = new JdbcConnector();
        try {
            connector.executePrStatement(script.CREATE_USER, email);
            log.info("User successful created");
        }finally {
            connector.disconnectFromDB();
        }
    }
    public void read(){
        JdbcConnector connector = new JdbcConnector();
        ResultSet resultSet = connector.readRecords(script.GET_USERS);
        try {
            if (resultSet.next()) {
                format(resultSet);
            }
            else {
                log.info("Database is empty");
            }
        }catch (SQLException e){
            log.info("In handleReadStmt(): " + e.getMessage());
        }finally {
            connector.disconnectFromDB();
        }
    }

    public void update(String user_id, String email){
        JdbcConnector connector = new JdbcConnector();
        try {
            log.info("Updated user:");
            ResultSet resultSet = new JdbcConnector().readRecords(script.GET_USER_BYID + user_id);
            format(resultSet);
            log.info("Enter new email:");
            connector.executeStatement(script.UPDATE_USER_BYID + email);
            log.info("User successful updated");
        }catch (SQLException e){
            log.warn(e.getMessage());
        }finally {
            connector.disconnectFromDB();
        }

    }

    public void delete(String user_id){

    }

    private void format(@NotNull ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int count = metaData.getColumnCount();
        for (int i = 1; i <= count; i++) {
            System.out.printf("%-15s%15s", metaData.getColumnName(i), "   |   ");
        }
        System.out.println();
        System.out.println("---------------------------------------"
                + "------------------------------------------------");
        do {
            for (int i = 1; i <= count; i++) {
                System.out.printf("%-15s%15s", resultSet.getObject(i), "   |   ");
            }
            System.out.println();
        } while (resultSet.next());

        System.out.println();
    }

}
