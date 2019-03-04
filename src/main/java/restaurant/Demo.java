package restaurant;

import restaurant.service.UserService;

public class Demo {
    public static void main(String[] args) {
        new UserService().create();
        new UserService().read();
        new UserService().update();
        new UserService().read();

    }
}
