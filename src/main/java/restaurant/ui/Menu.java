package restaurant.ui;


import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {
    private static final Logger log = Logger.getLogger(Menu.class);
    private Scanner scanner = new Scanner(System.in);


    public void displayMenu() {
        format("MENU:",
                "1: Admin Menu", "2: User Menu",
                "3: Order Menu",
                "0: Exit","SELECT OPTION:");
        options();
    }

    private void options() {
        try {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1:
                        new AdminMenu().displayMenu();
                    case 2:
                        new UserMenu().displayMenu();
                    case 3:
                        new OrderMenu().displayMenu();
                    case 0:
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