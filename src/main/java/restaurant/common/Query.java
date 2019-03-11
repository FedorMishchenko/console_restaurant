package restaurant.common;

public class Query {

    /*
    -----------------------------------------------------------------------
    */
    public static final String CREATE_USER = "INSERT INTO customer (email, password) " +
            "VALUES ( ?, ? )";
    public static final String UPDATE_USER = "UPDATE " +
            "restaurant.customer SET email = ?, password = ? WHERE email = ?";
    public static final String DELETE_USER_BY_LOGIN = "DELETE FROM customer WHERE email = ?";
    public static final String GET_USERS = "SELECT id, email, password FROM customer";
    public static final String GET_USER_BYID = "SELECT id, email, password FROM customer " +
            "WHERE id = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT id, email, password FROM customer " +
            "WHERE email = ?";
    /*
         -----------------------------------------------------------------------
    */
    public static final String GET_ORDERS_BYID = "SELECT id, item, price FROM order " +
            "WHERE customer_id = ?";
    public static final String CREATE_ORDER = "INSERT INTO order (customer_id, item, price) " +
            "VALUES ( ?, ?, ? ) ";
    public static final String UPDATE_ORDER = "UPDATE order SET item = ? , price = ? " +
            "WHERE item = ?";
    public static final String DELETE_ORDER = "DELETE FROM order WHERE customer_id = ? , item = ?";
    /*
         -----------------------------------------------------------------------
    */
    public static final String GET_ITEMS = "SELECT id, item, price FROM menu";
    public static final String GET_ITEM_BY_NAME = "SELECT id, item, price FROM menu " +
            "WHERE item = ?";
    public static final String CREATE_ITEM = "INSERT INTO menu (item, price) " +
            "VALUES ( ?, ? )";
    public static final String UPDATE_ITEM = "UPDATE menu SET item = ?, price = ? " +
            "WHERE item = ?";
    public static final String DELETE_ITEM = "DELETE FROM menu WHERE item = ?";
    /*
     -----------------------------------------------------------------------
    */
}
