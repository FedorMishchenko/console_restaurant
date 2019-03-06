package restaurant.ui;

import org.apache.log4j.Logger;
import restaurant.service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

 class AdminMenu {
    private static final Logger logger = Logger.getLogger(AdminMenu.class);
    private final String password = "www";
     private Format f = new Format();
    private Service service = Service.getInstance();
    private Scanner scanner = new Scanner(System.in);


      void displayMenu() {
        f.format("ADMIN MENU:", "1: Create Item",
                "2: Items",
                "3: Update Item", "4: Delete Item",
                "5: User Menu", "6: Order menu",
                "7: Commit", "8: Rollback",
                "9: Log out","0: Exit",
                "SELECT OPTION:");
        options();
    }

    private void options() {
        Integer index = 3;
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
                        new UserMenu().displayMenu();
                    case 6:
                        new OrderMenu().displayMenu();
                    case 7:
                        service.commit();
                        displayMenu();
                    case 8:
                        service.rollback();
                        displayMenu();
                    case 9:
                        new LoginPage().loginWindow();
                    case 0:
                        service.exit();
                        System.exit(0);
                    default:
                        logger.warn("Illegal argument");
                        displayMenu();
                }
            }
        } catch (InputMismatchException e) {
            logger.warn("Number format expected");
            displayMenu();
        }
    }

}
