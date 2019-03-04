package restaurant.service;

import restaurant.dao.UserDAO;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class UserService {
    private static final Logger log = Logger.getLogger(UserService.class);
    private Scanner scanner = new Scanner(System.in);
    private static UserDAO handler = UserDAO.getInstance();

    public void create(){
        log.info("Enter email:");
        String email = scanner.nextLine();
        handler.createStmt(email);
    }

    public void read(){
        handler.readStmt();
    }

    public void update(){
        log.info("Enter user_id");
        String user_id = scanner.nextLine();
        handler.updateStmt(user_id);

    }
    public void delete(){
        log.info("Enter user_id");
        String user_id = scanner.nextLine();
        handler.deleteStmt(user_id);
    }

}
