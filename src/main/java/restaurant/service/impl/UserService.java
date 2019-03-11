package restaurant.service.impl;

import restaurant.dao.UserDao;
import restaurant.entity.User;
import restaurant.exceptions.MyApplicationException;
import restaurant.service.Service;

public class UserService implements Service<User> {
    private UserDao userDao;
    public UserService(){
        userDao = new UserDao();
    }

    @Override
    public void create(User entity) {

        try {
            userDao.create(entity);
        }catch (Exception e){
            throw new MyApplicationException(e);
        }
    }

    @Override
    public User get(User entity) {

        try {
            return userDao.find(entity);
        }catch (Exception e){
            throw new MyApplicationException(e);
        }
    }

    @Override
    public void update(User entity1, User entity2) {
        try {
            userDao.update(entity1,entity2);
        }catch (Exception e){
            throw new MyApplicationException(e);
        }
    }

    @Override
    public void delete(User entity) {

        try {
            userDao.delete(entity);
        }catch (Exception e){
            throw new MyApplicationException(e);
        }
    }
}
