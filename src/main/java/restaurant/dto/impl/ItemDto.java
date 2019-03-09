package restaurant.dto.impl;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import restaurant.dto.EntityDto;

import java.util.Objects;

public final class ItemDto implements EntityDto {
    private Integer id;
    private String item;
    private Integer price;

    public ItemDto() {
    }

    @Contract(pure = true)
    public Integer getPrice() {
        return price;
    }

    @Contract("_ -> this")
    public ItemDto setPrice(Integer price) {
        this.price = price;
        return this;
    }

    @Contract(pure = true)
    public String getItem() {
        return item;
    }

    @Contract("_ -> this")
    public ItemDto setItem(String item) {
        this.item = item;
        return this;
    }

    @Contract("_ -> this")
    public ItemDto setId(Integer id) {
        this.id = id;
        return this;
    }

    @Contract(pure = true)
    @Override
    public Integer getId() {
        return this.id;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemDto)) return false;
        ItemDto itemDto = (ItemDto) o;
        return Objects.equals(getId(), itemDto.getId()) &&
                Objects.equals(getItem(), itemDto.getItem()) &&
                Objects.equals(getPrice(), itemDto.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getItem(), getPrice());
    }

    @NotNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ItemDto{");
        sb.append("id=").append(id);
        sb.append(", item='").append(item).append('\'');
        sb.append(", price='").append(price).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
