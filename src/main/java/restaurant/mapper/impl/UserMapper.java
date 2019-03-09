package restaurant.mapper.impl;

import restaurant.dto.impl.UserDto;
import restaurant.entity.User;
import restaurant.mapper.Mapper;

public class UserMapper implements Mapper<UserDto, User> {
    @Override
    public User mapToObject(UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        return user;
    }

    @Override
    public UserDto mapToDto(User object) {

        return new UserDto(object.getLogin(),
                object.getPassword());
    }
}
