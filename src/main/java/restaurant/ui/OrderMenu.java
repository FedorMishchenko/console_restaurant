package restaurant.ui;

import org.apache.log4j.Logger;
import restaurant.service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

 class OrderMenu {
    private static final Logger logger = Logger.getLogger(OrderMenu.class);
    private Scanner scanner = new Scanner(System.in);
    private Menu menu = new Menu();
    private Service service = Service.getInstance();

     void displayMenu(){
        menu.format("USER MENU:","1: Create Order",
                "2: Read Orders","3: Update Order",
                "4: Delete Order",
                "5: ","6: Menu",
                "7: ", "0: Exit",
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

                    case 4:
                    case 5:

                        break;
                    case 6:
                        new Menu().displayMenu();
                    case 7:

                        break;
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
}
