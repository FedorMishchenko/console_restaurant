package restaurant.dao;

import restaurant.common.Query;
import restaurant.connector.db.DBFactory;
import restaurant.entity.Order;
import restaurant.exceptions.EntityDaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements EntityDao<Order>{

    @Override
    public void create(Order entity) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(Query.CREATE_ORDER);
            statement.setInt(1, entity.getUserId());
            statement.setString(2, entity.getItem());
            statement.setString(3, entity.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }

    }

    @Override
    public Order find(Order entity) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    Query.GET_ORDERS_BYID);
      
            return null;
        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }

    public List<Order> findUserOrders(Integer id) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    Query.GET_ORDERS_BYID);
            statement.setInt(2, id);

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

    @Override
    public void update(Order oldOrder, Order newOrder) {
        Integer id = oldOrder.getOrderId();
        try  (Connection connection = new DBFactory().getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    Query.UPDATE_ORDER);

            statement.setString(1, newOrder.getItem());
            statement.setString(2, newOrder.getPrice());
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }

    @Override
    public void delete(Order order) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()) {
            Integer id = order.getOrderId();
            PreparedStatement statement = connection.prepareStatement(
                    Query.DELETE_ORDER + id);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }
}