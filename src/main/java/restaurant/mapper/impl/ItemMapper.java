package restaurant.mapper.impl;

import restaurant.dto.impl.ItemDto;
import restaurant.entity.Item;
import restaurant.mapper.Mapper;

public class ItemMapper implements Mapper <ItemDto, Item> {
    @Override
    public Item mapToObject(ItemDto origin) {
        Item item = new Item();
        item.setItem(origin.getItem());
        item.setPrice(origin.getPrice());
        return item;
    }

    @Override
    public ItemDto mapToDto(Item item) {
        return new ItemDto(item.getItem(),
                item.getPrice());
    }
}
