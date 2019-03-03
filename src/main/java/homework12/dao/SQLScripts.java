package homework12.dao;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

 class SQLScripts {
    @NotNull
    @Contract(" -> new")
     static SQLScripts getInstance(){
        return new SQLScripts();
    }
     final String getUsers = "SELECT id, email FROM restaurant.customer";
}
