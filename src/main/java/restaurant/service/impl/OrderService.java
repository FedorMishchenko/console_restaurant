package restaurant.service.impl;

import restaurant.dao.OrderDao;
import restaurant.entity.Order;
import restaurant.exceptions.MyApplicationException;
import restaurant.service.Service;

public class OrderService implements Service<Order> {
    private OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDao();
    }

    @Override
    public void create(Order entity) {
        //validation
        //check if exist
        //check if item is present

        try {
           orderDao.create(entity);
        } catch (Exception e) {
            throw new MyApplicationException(e);
        }
    }

    @Override
    public Order get(Order entity) {
        try {
            return orderDao.find(entity);
        }catch (Exception e){
            throw new MyApplicationException(e);
        }
    }

    @Override
    public void update(Order entity1, Order entity2) {
        try {
            orderDao.update(entity1, entity2);
        }catch (Exception e){
            throw new MyApplicationException(e);
        }
    }

    @Override
    public void delete(Order entity) {

    }
}
