package restaurant.service;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import restaurant.dao.HandlerDAO;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Service {
    private static final Logger log = Logger.getLogger(Service.class);
    private Scanner scanner = new Scanner(System.in);
    private static HandlerDAO handler = HandlerDAO.getInstance();
    @NotNull
    @Contract(" -> new")
    public static Service getInstance(){
        return new Service();
    }

    public void create(Integer index){
        switch (index){
            case 1:
                log.info("Enter email:");
                String args1 = scanner.nextLine();
                handler.create(index, args1);
                break;
            case 2:
                String []args2 = new String[3];
                log.info("Enter user_id");
                args2[0] = scanner.nextLine();
                log.info("Enter item");
                args2[1] = scanner.nextLine();
                log.info("Enter price");
                args2[2] = scanner.nextLine();
                handler.create(index, args2);
                break;
            case 3:
                String []args3 = new String[2];
                log.info("Enter item");
                args3[0] = scanner.nextLine();
                log.info("Enter price");
                args3[1] = scanner.nextLine();
                handler.create(index, args3);
                break;
        }
    }

    public void read(Integer index){
        switch (index){
            case 1:
                handler.read(index, null);
                break;
            case 2:
                log.info("Enter user_id");
                String id = scanner.nextLine();
                handler.read(index, id);
                break;
            case 3:
                handler.read(index, null);
                break;
        }
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
    public void exit(){
        handler.exit();
    }

}
