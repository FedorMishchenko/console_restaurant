package restaurant.controller.impl;

import restaurant.controller.Controller;
import restaurant.dto.impl.OrderDto;
import restaurant.dto.impl.UserDto;
import restaurant.entity.Order;
import restaurant.entity.User;
import restaurant.service.Service;
import restaurant.service.impl.OrderService;


public class OrderController implements Controller<OrderDto, UserDto> {
    private Service<User> userService;
    private Service<Order> orderService;

    public OrderController() {
        orderService = new OrderService();
    }

    public OrderController(Service<Order> orderService) {
        orderService = new OrderService();
    }

    @Override
    public void post(OrderDto entity) {

    }

    @Override
    public OrderDto get(OrderDto entity) {
        return null;
    }

    @Override
    public void put(OrderDto entity, OrderDto newEntity) {

    }

    @Override
    public void delete(OrderDto entity) {

    }
}
