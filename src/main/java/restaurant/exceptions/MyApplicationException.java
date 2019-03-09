package restaurant.exceptions;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class MyApplicationException extends RuntimeException {
    private static final Logger log = Logger.getLogger(MyApplicationException.class);
    public MyApplicationException(@NotNull Exception e) {
        e.printStackTrace();
        log.warn(e.getMessage());
        log.warn(e.getCause());
    }
}
