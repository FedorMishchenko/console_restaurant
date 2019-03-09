package restaurant.dao;

import restaurant.common.Query;
import restaurant.connector.db.DBFactory;
import restaurant.entity.Order;
import restaurant.entity.User;
import restaurant.exceptions.EntityDaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    public void create(Order entity) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(Query.CREATE_ORDER);

            statement.setInt(2, entity.getUserId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }

    }

    public Order find(User entity) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    Query.GET_ORDERS_BYID);
            statement.setInt(1, entity.getId());

            ResultSet resultSet = statement.executeQuery();

            Order order = new Order();
            while (resultSet.next()) {
                order.setOrderId(entity.getId());
                order.setUserId(resultSet.getInt(2));
                order.setItem(resultSet.getString(3));
                order.setPrice(resultSet.getString(4));
            }
            return order;
        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }

    public List<Order> findUserOrders(Integer id) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    Query.GET_ORDERS_BYID);
            statement.setInt(2, id);
            connection.setTransactionIsolation(4);

            ResultSet resultSet = statement.executeQuery();

            List<Order> list = new ArrayList<>();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt(1));
                order.setUserId(resultSet.getInt(2));
                order.setItem(resultSet.getString(3));
                order.setPrice(resultSet.getString(4));
                list.add(order);
            }
            return list;
        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }

    public void update(Order order) {
        Integer id = order.getOrderId();
        try  (Connection connection = new DBFactory().getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    Query.UPDATE_ORDER + id);
            connection.setTransactionIsolation(4);

            statement.executeUpdate();
            /*return null;*/
        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }

    public void delete(Order order) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()) {
            Integer id = order.getOrderId();
            PreparedStatement statement = connection.prepareStatement(
                    Query.DELETE_ORDER + id);

            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
          /*  return metaData.getColumnCount();*/

        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }
}
