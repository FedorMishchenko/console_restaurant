package restaurant.ui;

import org.apache.log4j.Logger;
import restaurant.service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

 class AdminMenu {
    private static final Logger logger = Logger.getLogger(AdminMenu.class);
    private final String password = "www";
    private Menu menu = new Menu();
    private Service service = Service.getInstance();
    private Scanner scanner = new Scanner(System.in);


     void displayMenu() {
        menu.format("ADMIN MENU:", "1: Create Item",
                "2: Items",
                "3: Update Item", "4: Delete Item",
                "5: Menu",
                "0: Exit","SELECT OPTION:");
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
                        new Menu().displayMenu();
                    case 0:
                        service.exit();
                        exit(0);
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


     void check () {
        menu.format("Enter password:");
        if ((scanner.nextLine()).equals(password)) {
            logger.info("Password accepted");
        } else {
            logger.info("Invalid password");
            new Menu().displayMenu();
        }
    }
}
