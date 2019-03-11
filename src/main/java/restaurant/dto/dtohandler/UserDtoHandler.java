package restaurant.dto.dtohandler;

import org.apache.log4j.Logger;
import restaurant.dto.EntityDto;
import restaurant.dto.impl.UserDto;

import java.util.Scanner;

public class UserDtoHandler extends DtoHandler{
    private static final Logger log = Logger.getLogger(UserDtoHandler.class);
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public EntityDto init(){
        log.info("Enter login:");
        String login = scanner.nextLine();
        log.info("Enter password:");
        String password = scanner.nextLine();
        return new UserDto().setLogin(login).setPassword(password);
    }
}
