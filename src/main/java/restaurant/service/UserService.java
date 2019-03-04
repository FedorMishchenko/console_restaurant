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
        handler.create(email);
    }

    public void read(){
        handler.read();
    }

    public void update(){
        log.info("Enter user_id");
        String user_id = scanner.nextLine();
        log.info("Enter new email:");
        String email = scanner.nextLine();
        handler.update(user_id, email);

    }
    public void delete(){
        log.info("Enter user_id");
        String user_id = scanner.nextLine();
        handler.delete(user_id);
    }

}
