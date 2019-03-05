package restaurant.ui;


import org.apache.log4j.Logger;
import restaurant.service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {
    private static final Logger log = Logger.getLogger(Menu.class);
    private Scanner scanner = new Scanner(System.in);
    private Service service = Service.getInstance();
    private AdminMenu admin = new AdminMenu();
    private UserMenu user = new UserMenu();


    public void displayMenu() {
        format("MENU:",
                "1: Admin Menu", "2: User Menu",
                "0: Exit","SELECT OPTION:");
        options();
    }

    private void options() {
        try {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1:
                        admin.check();
                        admin.displayMenu();
                    case 2:

                        user.login();
                    case 0:
                        service.exit();
                        exit(0);
                    default:
                        log.warn("Illegal argument");
                        displayMenu();
                }
            }
        } catch (InputMismatchException e) {
            log.warn("Number format expected");
            displayMenu();
        }
    }

     void format(String... s) {
        System.out.printf("%9s%-20s%n"," ","----------------------------");
        for (String str : s) {
            System.out.printf("%15s%-20s%2s%n", "|     ",str,"|");
        }
        System.out.printf("%9s%-20s%n"," ","----------------------------");
    }
}