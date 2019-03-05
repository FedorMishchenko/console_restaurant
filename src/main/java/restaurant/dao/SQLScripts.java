package restaurant.dao;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

 class SQLScripts {

    @NotNull
    @Contract(" -> new")
     static SQLScripts getInstance(){
        return new SQLScripts();
    }
/*
    -----------------------------------------------------------------------
*/
     final String GET_USERS = "SELECT id, email FROM restaurant.customer";
     final String CREATE_USER = "INSERT INTO restaurant.customer (email) " +
             "VALUES ( ? )";
     final String UPDATE_USER_BYID = "UPDATE " +
             "restaurant.customer SET email = ?  WHERE id = ";
     final String DELETE_BYID = "DELETE FROM restaurant.customer WHERE id = ";
/*
     -----------------------------------------------------------------------
*/
    final String GET_ORDERS_BYID = "SELECT id, item, price FROM restaurant.order " +
        "WHERE customer_id = ";
    final String CREATE_ORDER = "INSERT INTO restaurant.order (customer_id, item, price) " +
            "VALUES ( ?, ?, ? ) ";
    final String UPDATE_ORDER = "UPDATE restaurant.order SET item = ? , price = ? " +
            "WHERE customer_id = ";
    final String DELETE_ORDER = "DELETE FROM restaurant.order WHERE customer_id = ";
/*
     -----------------------------------------------------------------------
*/
    final String GET_ITEMS = "SELECT id, item, price FROM restaurant.menu";
    final String CREATE_ITEM = "INSERT INTO restaurant.menu (item, price) " +
            "VALUES ( ?, ? )";
    final String UPDATE_ITEM = "UPDATE restaurant.menu SET item = ?, price = ? " +
            "WHERE id = ";
    final String DELETE_ITEM = "DELETE FROM restaurant.menu WHERE id = ";

}
