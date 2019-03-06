package restaurant.ui;

import org.apache.log4j.Logger;
import restaurant.service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderMenu {
    private static final Logger logger = Logger.getLogger(OrderMenu.class);
    private Scanner scanner = new Scanner(System.in);
    private Format f = new Format();
    private Service service = Service.getInstance();
    private String id = LoginPage.id;
    public String getId(){
        return this.id;
    }

      void displayMenu(){
        f.format("USER MENU:","1: Create Order",
                "2: Read Orders","3: Update Order",
                "4: Delete Order", "5: Save changes",
                "6: Cancel changes", "7: Log out",
                "0: Exit",
                "SELECT OPTION:");
        options();
    }
    private void options(){
        Integer index = 2;
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
                        logger.warn("Illegal argument");
                        displayMenu();
                }
            }
        }catch (InputMismatchException e){
            logger.warn("Number format expected");
            displayMenu();
        }

    }
}
