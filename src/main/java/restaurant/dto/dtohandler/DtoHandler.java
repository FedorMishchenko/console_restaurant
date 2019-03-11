package restaurant.dto.dtohandler;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import restaurant.connector.console.ConsoleConnector;
import restaurant.controller.Controller;
import restaurant.dto.EntityDto;

import java.util.Scanner;

public abstract class DtoHandler {
    private static Logger log = Logger.getLogger(DtoHandler.class);
    private static Scanner scanner = new Scanner(System.in);

    @Contract(pure = true)
    public void transfer(Controller controller){
        EntityDto entityDto = init();
        while (true){
            log.info("Enter: post, get, up, del, exit");
            switch (scanner.nextLine()){
                case "post":
                    controller.post(entityDto);
                    break;
                case "get":
                    controller.get(entityDto);
                case "up":
                    controller.put(entityDto,init());
                case "del":
                    controller.delete(entityDto);
                case "exit":
                    ConsoleConnector.start();
            }
        }

    }
    public abstract EntityDto init();
}
