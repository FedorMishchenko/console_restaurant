package restaurant.exceptions;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class EntityDaoException extends RuntimeException {
    private static final Logger log = Logger.getLogger(EntityDaoException.class);

    public EntityDaoException(@NotNull SQLException e) {
        e.printStackTrace();
        log.warn(e.getMessage());
        log.warn(e.getCause());
    }
}
