package restaurant.ui;

import org.apache.log4j.Logger;
import restaurant.service.Service;

import java.util.Scanner;


public class LoginPage {
    private static final Logger log = Logger.getLogger(LoginPage.class);
    private Format f = new Format();
    private Scanner scanner = new Scanner(System.in);
    private Service service = Service.getInstance();
    String[] info = new String[3];
    private String email;
    private String password;
    static String id;

    public void loginWindow() {
        f.format("Enter email");
        email = scanner.nextLine();

        f.format("Enter password");
        password = scanner.nextLine();
        validate();
        if (info[1].equals("admin")) {
            new AdminMenu().displayMenu();
        } else {
            new OrderMenu().displayMenu();
        }
    }

    private void validate() {
        info = service.findUser(email, password);
        id = info[0];
        if (id == null) {
            new LoginPage().loginWindow();
        }
    }
}
