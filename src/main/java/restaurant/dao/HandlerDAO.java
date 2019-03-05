package restaurant.dao;

import org.jetbrains.annotations.Contract;
import restaurant.db.JdbcConnector;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class HandlerDAO {
    private static final Logger log = Logger.getLogger(HandlerDAO.class);
    private static SQLScripts script = SQLScripts.getInstance();
    private JdbcConnector connector = new JdbcConnector();

    @NotNull
    @Contract(" -> new")
    public static HandlerDAO getInstance() {
        return new HandlerDAO();
    }

    public void create(Integer index, String... args) {
        switch (index){
            case 1:
                connector.executePreparedStatement(script.CREATE_USER, args);
                log.info("User successful created");
                break;
            case 2:
                connector.executePreparedStatement(script.CREATE_ORDER, args);
                log.info("Order successful created");
                break;
            case 3:
                break;
        }
    }

    public void read(Integer index, String id) {
        ResultSet resultSet = null;
        try {
            switch (index){
                case 1:
                    resultSet = connector.readRecords(script.GET_USERS);
                    if (resultSet.next()) {
                        format(resultSet);
                    } else {
                        log.info("Database is empty");
                    }
                    break;
                case 2:
                    resultSet = connector.readRecords(script.GET_ORDERS_BYID + id);
                    if (resultSet.next()) {
                        format(resultSet);
                    } else {
                        log.info("Database is empty");
                    }
                    break;
                case 3:
                    break;
            }
        } catch (SQLException e) {
            log.info(e.getMessage());

        } finally {
            connector.disconnectFromDB();
        }
    }



    public void update(String user_id, String email) {
        connector.executePreparedStatement(
                script.UPDATE_USER_BYID + user_id, email);
        log.info("User successful updated");

    }

    public void delete(String user_id) {
        connector.executeStatement(
                script.DELETE_BYID + user_id);

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

    public void exit() {
        connector.disconnectFromDB();
    }

}
