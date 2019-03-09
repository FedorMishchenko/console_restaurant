package restaurant.mapper.impl;

import javafx.util.Pair;
import restaurant.dto.impl.UserOrderDto;
import restaurant.entity.Order;
import restaurant.entity.User;
import restaurant.mapper.Mapper;

public class UserOrderMapper implements Mapper<Pair<User, Order>, UserOrderDto> {
    @Override
    public UserOrderDto mapToObject(Pair<User, Order> origin) {

        return null;
    }

    @Override
    public Pair<User, Order> mapToDto(UserOrderDto object) {

        return null;
    }
}
