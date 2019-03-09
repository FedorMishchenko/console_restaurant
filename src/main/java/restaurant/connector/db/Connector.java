package restaurant.connector.db;

import java.sql.Connection;

public interface Connector {
    Connection getConnection();
}
