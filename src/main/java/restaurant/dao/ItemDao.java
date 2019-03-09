package restaurant.dao;

import restaurant.common.Query;
import restaurant.connector.db.DBFactory;
import restaurant.entity.Item;
import restaurant.exceptions.EntityDaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {

    public void create(Item entity) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    Query.CREATE_ITEM);

            statement.setString(2, entity.getItem());
            statement.setString(3, entity.getPrice());

           statement.executeUpdate();
         /*  return new Item();*/

        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }

    public Item find(Item entity) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    Query.GET_ITEM_BY_NAME);
            statement.setString(1, entity.getItem());

            ResultSet resultSet = statement.executeQuery();

            Item item = new Item();
            while (resultSet.next()) {
                /*item.setId();*/
                item.setItem(resultSet.getString(2));
                item.setPrice(resultSet.getString(3));
            }
            return item;
        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }

    public void update(Item entity) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    Query.UPDATE_ITEM_BYID);

            statement.setInt(1, entity.getId());
            statement.setString(2,entity.getItem());
            statement.setString(3,entity.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }

    public void delete(Item entity) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    Query.DELETE_ITEM_BYID);

            statement.setInt(1, entity.getId());

            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();

        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }

    public List<Item> getItems(){
        try  (Connection connection = new DBFactory().getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    Query.GET_ITEMS);
            connection.setTransactionIsolation(4);
            ResultSet resultSet = statement.executeQuery();

            List<Item> list = new ArrayList<>();
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt(1));
                item.setItem(resultSet.getString(2));
                item.setPrice(resultSet.getString(3));
                list.add(item);
            }
            return list;
        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }
}
