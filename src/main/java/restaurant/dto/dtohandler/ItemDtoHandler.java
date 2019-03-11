package restaurant.dto.dtohandler;

import org.apache.log4j.Logger;
import restaurant.dto.EntityDto;
import restaurant.dto.impl.ItemDto;

import java.util.Scanner;


public class ItemDtoHandler extends DtoHandler {
    private static final Logger log = Logger.getLogger(ItemDtoHandler.class);
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public EntityDto init() {
        log.info("Enter item");
        String item = scanner.nextLine();
        log.info("Enter price");
        String price = scanner.nextLine();
        return new ItemDto().setItem(item).setPrice(price);
    }
}
