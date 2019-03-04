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
     final String CREATE_USER = "INSERT INTO restaurant.customer (email)" +
             " VALUES ( ? )";
     final String UPDATE_USER_BYID = "UPDATE" +
             " restaurant.customer SET email = ?  WHERE id = ";
     final String DELETE_BYID = "DELETE FROM restaurant.customer WHERE id = ";

/*
     -----------------------------------------------------------------------
*/



}
