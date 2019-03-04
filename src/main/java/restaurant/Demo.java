package restaurant;

import restaurant.service.UserService;

public class Demo {
    public static void main(String[] args) {

        new UserService().read();
        new UserService().update();
        new UserService().read();
        new UserService().delete();
        new UserService().read();

    }
}
