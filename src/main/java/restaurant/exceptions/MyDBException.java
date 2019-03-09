package restaurant.exceptions;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class MyDBException extends RuntimeException {
    private final Logger log = Logger.getLogger(MyDBException.class);

    public MyDBException(@NotNull Throwable e) {
        e.printStackTrace();
        log.warn(e.getMessage());
        log.warn(e.getCause());
    }
}
