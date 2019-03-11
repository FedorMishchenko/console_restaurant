package restaurant.dao;

import restaurant.common.Query;
import restaurant.connector.db.DBFactory;

import restaurant.entity.User;
import restaurant.exceptions.EntityDaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements EntityDao<User>{

    @Override
    public void create(User entity) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    Query.CREATE_USER);

            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }

    @Override
    public User find(User entity){
        try  (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
            Query.GET_USER_BY_LOGIN);
            statement.setString(1,entity.getLogin());
            ResultSet resultSet = statement.executeQuery();

            User user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }
            return user;
        }
        catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }

    @Override
    public void update(User oldUser, User newUser) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    Query.UPDATE_USER);
            statement.setString(1,newUser.getLogin());
            statement.setString(2,newUser.getPassword());
            statement.setString(3, oldUser.getLogin());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }

    @Override
    public void delete(User entity) {
        try  (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    Query.DELETE_USER_BY_LOGIN);

            statement.setString(1, entity.getLogin());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }

    public List<User> getUsers() {
        try  (Connection connection = new DBFactory().getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    Query.GET_USERS);
            ResultSet resultSet = statement.executeQuery();

            List<User> list = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            throw new EntityDaoException(e);
        }
    }
}
