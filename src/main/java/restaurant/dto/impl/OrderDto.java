package restaurant.dto.impl;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import restaurant.dto.EntityDto;

import java.util.Objects;

public final class OrderDto implements EntityDto {
    private Integer userId;
    private String item;
    private String price;

    public OrderDto() {
    }
    public OrderDto(String item,String price){
        this.item = item;
        this.price = price;
    }

    @Contract(pure = true)
    public String getItem() {
        return item;
    }

    @Contract("_ -> this")
    public OrderDto setItem(String item) {
        this.item = item;
        return this;
    }

    @Contract(pure = true)
    public String getPrice() {
        return price;
    }

    @Contract("_ -> this")
    public OrderDto setPrice(String price) {
        this.price = price;
        return this;
    }

    @Contract(pure = true)
    public Integer getUserId() {
        return userId;
    }

    @Contract("_ -> this")
    public OrderDto setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    @Nullable
    @Contract(pure = true)
    @Override
    public Integer getId() {
        return this.userId;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDto)) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(getUserId(), orderDto.getUserId()) &&
                getItem().equals(orderDto.getItem()) &&
                getPrice().equals(orderDto.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getItem(), getPrice());
    }

    @NotNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDto{");
        sb.append("userId=").append(userId);
        sb.append(", item='").append(item).append('\'');
        sb.append(", price='").append(price).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
