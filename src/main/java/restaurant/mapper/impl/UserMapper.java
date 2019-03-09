package restaurant.mapper.impl;

import restaurant.dto.impl.UserDto;
import restaurant.entity.User;
import restaurant.mapper.Mapper;

public class UserMapper implements Mapper<UserDto, User> {
    @Override
    public User mapToObject(UserDto origin) {
        User user = new User();
        user.setLogin(origin.getLogin());
        user.setPassword(origin.getPassword());
        return user;
    }

    @Override
    public UserDto mapToDto(User user) {
        return new UserDto(user.getLogin(),
                user.getPassword());
    }
}
