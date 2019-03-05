package restaurant.ui;

import org.apache.log4j.Logger;
import restaurant.service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

 class UserMenu {
    private static final Logger logger = Logger.getLogger(UserMenu.class);
    private Menu menu = new Menu();
    private Service service = Service.getInstance();
    private Scanner scanner = new Scanner(System.in);

     void displayMenu(){
        menu.format("USER MENU:","1: Create User",
                "2: Read Users","3: Update User",
                "4: Delete User",
                "5: Order Menu","6: Menu",
                "7: Save changes",
                "8: Cancel changes","0: Exit",
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
                        new OrderMenu().displayMenu();
                    case 6:
                        new Menu().displayMenu();
                    case 7:
                        service.commit();
                        displayMenu();
                    case 8:
                        service.rollback();
                        displayMenu();
                    case 0:
                        service.exit();
                        exit(0);
                    default:
                        logger.warn("Illegal argument");
                        displayMenu();
                }
            }
        }catch (InputMismatchException e){
            logger.warn("Number format expected");
            displayMenu();
        }
    }

     void login(){

    }
}