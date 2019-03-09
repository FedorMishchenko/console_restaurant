package restaurant.connector.console;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import restaurant.controller.Controller;
import restaurant.controller.impl.ItemController;
import restaurant.controller.impl.OrderController;
import restaurant.controller.impl.UserController;
import restaurant.dto.EntityDto;
import restaurant.dto.impl.ItemDto;
import restaurant.dto.impl.OrderDto;
import restaurant.dto.impl.UserDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleConnector {
    private static final Logger log = Logger.getLogger(ConsoleConnector.class);
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Controller> commandMap;
    private static Map<String, Object> session;

    public static void init() {
        commandMap = new HashMap<>();
        commandMap.put("user", new UserController());
        commandMap.put("order", new OrderController());
        commandMap.put("item", new ItemController());

    }

    public static void start() {
        while (true) {
            log.info("Enter command: user, order, item");
            start(scanner.nextLine());
        }
    }

    public static void start(String command) {
        Controller controller = commandMap.get(command);
        switch (command) {
            case "user":
                transfer(userDtoInit(), controller);
                break;
            case "order":
                transfer(orderDtoInit(),controller);
                break;
            case "item":
                transfer(itemDtoInit(),controller);
                break;
        }
    }
    @Nullable
    private static EntityDto transfer(EntityDto entityDto, Controller controller){
        log.info("Enter: post, get, up, del");
        switch (scanner.nextLine()){
            case "post":
                controller.post(entityDto);
                break;
            case "get":
                controller.get(entityDto);
                break;
            case "up":
                UserDto userDto = new UserDto();
                log.info("Enter login update");
                userDto.setLogin(scanner.nextLine());
                log.info("Enter password update");
                userDto.setPassword(scanner.nextLine());
                controller.put(entityDto,userDto);
                break;
            case "del":
                controller.delete(entityDto);
                break;
        }
        return null;
    }

    private static UserDto userDtoInit(){
        log.info("Enter login:");
        String login = scanner.nextLine();
        log.info("Enter password:");
        String password = scanner.nextLine();
        return new UserDto().setLogin(login).setPassword(password);

    }
    @Nullable
    @Contract(pure = true)
    private static OrderDto orderDtoInit(){
        log.info("Enter item:");
        String item = scanner.nextLine();
        log.info("Enter price:");
        String price = scanner.nextLine();
        log.info("Enter user id:");
        Integer id = scanner.nextInt();
        return new OrderDto().setItem(item).setPrice(price).setUserId(id);

    }
    @Nullable
    @Contract(pure = true)
    private static ItemDto itemDtoInit(){
        log.info("Enter item:");
        String item = scanner.nextLine();
        log.info("Enter price:");
        Integer price = scanner.nextInt();
        return new ItemDto().setItem(item).setPrice(price);
    }
}
