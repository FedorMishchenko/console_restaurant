package restaurant.ui;

import org.apache.log4j.Logger;
import restaurant.service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;


 class UserMenu {
    private static final Logger logger = Logger.getLogger(UserMenu.class);
     private Format f = new Format();
    private Service service = Service.getInstance();
    private Scanner scanner = new Scanner(System.in);

     void displayMenu(){
        f.format("USER MENU:","1: Create User",
                "2: Read Users","3: Update User",
                "4: Delete User", "5: Save changes",
                "6: Cancel changes",
                "7: Log out","0: Exit",
                "SELECT OPTION:");
        options();
    }

    private void options(){
        Integer index = 1;
        try {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1:
                        service.create(index);
                        displayMenu();
                    case 2:
                        service.read(index);
                        displayMenu();
                    case 3:
                        service.update(index);
                        displayMenu();
                    case 4:
                        service.delete(index);
                        displayMenu();
                    case 5:
                        service.commit();
                        displayMenu();
                    case 6:
                        service.rollback();
                        displayMenu();
                    case 7:
                        new LoginPage().loginWindow();
                    case 0:
                        service.exit();
                        System.exit(0);
                    default:
                        logger.warn("Not legal argument");
                        displayMenu();
                }
            }
        }catch (InputMismatchException e){
            logger.warn("Number expected");
            displayMenu();
        }
    }

     void login(){
        displayMenu();
    }
}