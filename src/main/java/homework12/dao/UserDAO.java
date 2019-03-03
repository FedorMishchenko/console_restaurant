package homework12.dao;

import homework12.db.JdbcConnector;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class UserDAO {
    private static final Logger log = Logger.getLogger(UserDAO.class);
    private JdbcConnector connector = new JdbcConnector();
    private static SQLScripts script = SQLScripts.getInstance();

    @NotNull
    @Contract(" -> new")
    public static UserDAO getInstance(){
        return new UserDAO();
    }

    public void handleCreateStmt(String param){

    }
    public void handleReadStmt(){
        ResultSet resultSet = connector.readRecords(script.getUsers);
        try {
            if (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int count = metaData.getColumnCount();
                for (int i = 1; i <= count; i++) {
                    System.out.printf("%-8s", metaData.getColumnName(i));
                }
                System.out.println();
                do {
                    for (int i = 1; i <= count; i++) {
                        System.out.printf("%-8s", resultSet.getObject(i));
                    }
                    System.out.println();
                } while (resultSet.next());

                System.out.println();
            }
            else {
                System.out.println("Database is empty");
            }
            connector.disconnectFromDB();
        }catch (SQLException e){
            log.info("In handleReadStmt(): " + e.getMessage());
        }
    }

    public void handleUpdateStmt(String param){

    }

    public void handleDeleteStmt(String param){

    }


}
