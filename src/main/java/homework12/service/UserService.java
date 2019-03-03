package homework12.service;

import homework12.dao.UserDAO;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class UserService {
    private static final Logger log = Logger.getLogger(UserService.class);
    private Scanner scanner = new Scanner(System.in);
    private static UserDAO converter = UserDAO.getInstance();

    public void create(){
        log.info("Enter email:");
        String email = scanner.nextLine();
        converter.handleCreateStmt(email);
    }

    public void read(){
        converter.handleReadStmt();
    }

    public void update(){
        log.info("Enter user_id");
        String user_id = scanner.nextLine();
        converter.handleUpdateStmt(user_id);

    }
    public void delete(){
        log.info("Enter user_id");
        String user_id = scanner.nextLine();
        converter.handleDeleteStmt(user_id);
    }

}
