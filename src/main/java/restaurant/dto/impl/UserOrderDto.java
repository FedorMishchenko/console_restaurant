package restaurant.dto.impl;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import restaurant.dto.EntityDto;

public final class UserOrderDto implements EntityDto {
    @Nullable
    @Contract(pure = true)
    @Override
    public Integer getId() {
        return null;
    }
}
