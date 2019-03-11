package restaurant.connector.console;

import org.apache.log4j.Logger;
import restaurant.controller.Controller;
import restaurant.controller.impl.ItemController;
import restaurant.controller.impl.OrderController;
import restaurant.controller.impl.UserController;
import restaurant.dto.dtohandler.DtoHandler;
import restaurant.dto.dtohandler.ItemDtoHandler;
import restaurant.dto.dtohandler.OrderDtoHandler;
import restaurant.dto.dtohandler.UserDtoHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleConnector {
    private static final Logger log = Logger.getLogger(ConsoleConnector.class);
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Controller> commandMap;
    private static Map<String, DtoHandler> session;

    public static void init() {
        commandMap = new HashMap<>();
        commandMap.put("user", new UserController());
        commandMap.put("order", new OrderController());
        commandMap.put("item", new ItemController());
        session = new HashMap<>();
        session.put("user", new UserDtoHandler());
        session.put("order", new OrderDtoHandler());
        session.put("item", new ItemDtoHandler());

    }

    public static void start() {
        while (true) {
            log.info("Enter command: user, order, item");
            start(scanner.nextLine());
        }
    }

    private static void start(String command) {
        Controller controller = commandMap.get(command);
        DtoHandler handler = session.get(command);
        switch (command) {
            case "user":
               handler.transfer(controller);
                break;
            case "order":
                handler.transfer(controller);
                break;
            case "item":
                handler.transfer(controller);
                break;
        }
    }
}
