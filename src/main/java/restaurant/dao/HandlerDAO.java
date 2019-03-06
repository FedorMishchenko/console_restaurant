package restaurant.dao;

import org.jetbrains.annotations.Contract;
import restaurant.db.JdbcConnector;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

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
                connector.executePreparedStatement(script.CREATE_ITEM, args);
                log.info("Item successful created");
                break;
        }
    }

    public void read(Integer index, String id) {
        ResultSet resultSet;
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
                    resultSet = connector.readRecords(script.GET_ITEMS);
                    if (resultSet.next()) {
                        format(resultSet);
                    } else {
                        log.info("Database is empty");
                    }
                    break;
            }
        } catch (SQLException e) {
            log.info(e.getMessage());

        }
    }



    public void update(Integer index, String ...args) {
        String []param = new String[2];
        switch (index){
            case 1:
                connector.executePreparedStatement(
                        script.UPDATE_USER_BYID + args[0], args[1]);
                log.info("User successful updated");
                break;
            case 2:
                System.arraycopy(args,1,param,0,args.length - 1);
                connector.executePreparedStatement(script.UPDATE_ORDER + args[0], param);
                log.info("Order successful updated");
                break;
            case 3:
                System.arraycopy(args, 1,param, 0, args.length - 1);
                connector.executePreparedStatement(script.UPDATE_ITEM + args[0], param);
                log.info("Item successful updated");
                break;
        }
    }

    public void delete(Integer index, String id) {
        switch (index) {
            case 1:
                connector.executeStatement(
                        script.DELETE_BYID + id);
                log.info("User successful deleted");
                break;
            case 2:
                connector.executeStatement(
                        script.DELETE_ORDER + id);
                log.info("Order successful deleted");
                break;
            case 3:
                connector.executeStatement(
                        script.DELETE_ITEM + id);
                log.info("Item successful deleted");
                break;
        }
    }

    public String[] findId(String email, String password){
        ResultSet resultSet;
        resultSet = connector.readRecords("SELECT id, email FROM restaurant.customer WHERE " +
                "email = '" + email + /*"' , password = '" + password + */"'");
        String id = null;
        String user_email = null;
        try {
            if(resultSet.next()) {
                id = resultSet.getString(1);
                user_email = resultSet.getString(2);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new String[]{id, user_email};
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

    public void commit(){
        connector.commit();
    }

    public void rollback(){
        connector.rollback();
    }

    public void exit() {
        connector.disconnectFromDB();
    }

}
