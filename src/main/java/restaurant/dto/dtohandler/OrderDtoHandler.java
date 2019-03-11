package restaurant.dto.dtohandler;

import org.apache.log4j.Logger;
import restaurant.dto.EntityDto;
import restaurant.dto.impl.OrderDto;

import java.util.Scanner;

public class OrderDtoHandler extends DtoHandler {
    private static final Logger log = Logger.getLogger(OrderDtoHandler.class);
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public EntityDto init() {
        log.info("Enter userId");
        Integer userId = scanner.nextInt();
        log.info("Enter item");
        String item = scanner.nextLine();
        log.info("Enter price");
        String price = scanner.nextLine();
        return new OrderDto().setUserId(userId).setItem(item).setPrice(price);

    }
}
