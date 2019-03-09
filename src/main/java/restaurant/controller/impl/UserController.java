package restaurant.controller.impl;

import restaurant.controller.Controller;
import restaurant.dto.impl.UserDto;
import restaurant.entity.Order;
import restaurant.entity.User;
import restaurant.mapper.impl.UserMapper;
import restaurant.service.Service;
import restaurant.service.impl.UserService;

public class UserController implements Controller<UserDto,Integer> {
    private Service<User> userService;
    private Service<Order> orderService;


    public UserController() {
        userService = new UserService();
    }

    public UserController(Service<User> userService) {
        this.userService = userService;
    }

    @Override
    public void post(UserDto entity) {
        User user = new UserMapper().mapToObject(entity);
        userService.create(user);

    }

    @Override
    public UserDto get(UserDto entity) {
        User user = new UserMapper().mapToObject(entity);
        User foundUser = userService.get(user);
        return new UserMapper().mapToDto(foundUser);
    }


    @Override
    public void put(UserDto entity, UserDto newEntity) {
        User user = new UserMapper().mapToObject(entity);
        User newUser = new UserMapper().mapToObject(newEntity);
        userService.update(user, newUser);

    }

    @Override
    public void delete(UserDto entity) {
        User user = new UserMapper().mapToObject(entity);
        userService.delete(user);
    }

}
