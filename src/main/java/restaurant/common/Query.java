package restaurant.common;

public class Query {

    /*
    -----------------------------------------------------------------------
    */
    public static final String CREATE_USER = "INSERT INTO restaurant.customer (email, password) " +
            "VALUES ( ?, ? )";
    public static final String UPDATE_USER_BYID = "UPDATE " +
            "restaurant.customer SET email = ?, password = ? WHERE id = ?";
    public static final String DELETE_USER_BY_LOGIN = "DELETE FROM restaurant.customer WHERE email = ?";
    public static final String GET_USERS = "SELECT id, email, password FROM restaurant.customer";
    public static final String GET_USER_BYID = "SELECT id, email, password FROM restaurant.customer " +
            "WHERE id = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT id, email, password FROM restaurant.customer " +
            "WHERE email = ?";
    /*
         -----------------------------------------------------------------------
    */
    public static final String GET_ORDERS_BYID = "SELECT id, item, price FROM restaurant.order " +
            "WHERE customer_id = ?";
    public static final String CREATE_ORDER = "INSERT INTO restaurant.order (customer_id, item, price) " +
            "VALUES ( ?, ?, ? ) ";
    public static final String UPDATE_ORDER = "UPDATE restaurant.order SET item = ? , price = ? " +
            "WHERE id = ?";
    public static final String DELETE_ORDER = "DELETE FROM restaurant.order WHERE id = ?";
    /*
         -----------------------------------------------------------------------
    */
    public static final String GET_ITEMS = "SELECT id, item, price FROM restaurant.menu";
    public static final String GET_ITEM_BY_NAME = "SELECT id, item, price FROM restaurant.menu " +
            "WHERE item = ?";
    public static final String CREATE_ITEM = "INSERT INTO restaurant.menu (item, price) " +
            "VALUES ( ?, ? )";
    public static final String UPDATE_ITEM_BYID = "UPDATE restaurant.menu SET item = ?, price = ? " +
            "WHERE id = ?";
    public static final String DELETE_ITEM_BYID = "DELETE FROM restaurant.menu WHERE id = ?";
    /*
     -----------------------------------------------------------------------
    */
}
