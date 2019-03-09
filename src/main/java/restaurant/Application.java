package restaurant;


import restaurant.connector.console.ConsoleConnector;

public class Application {
    public static void main(String[] args) {
        ConsoleConnector.init();
        ConsoleConnector.start();

    }
}
