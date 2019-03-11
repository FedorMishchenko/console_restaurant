package restaurant.controller.impl;

import restaurant.controller.Controller;
import restaurant.dto.impl.ItemDto;
import restaurant.entity.Item;
import restaurant.mapper.impl.ItemMapper;
import restaurant.service.Service;
import restaurant.service.impl.ItemService;

public class ItemController implements Controller<ItemDto,Integer> {
    private Service<Item> itemService;
    public ItemController(){
        itemService = new ItemService();
    }
    @Override
    public void post(ItemDto entity) {
        Item item = new ItemMapper().mapToObject(entity);
        itemService.create(item);
    }

    @Override
    public ItemDto get(ItemDto entity) {
        Item item = new ItemMapper().mapToObject(entity);
        Item foundItem = itemService.get(item);
        return new ItemMapper().mapToDto(foundItem);
    }

    @Override
    public void put(ItemDto entity1, ItemDto entity2) {
        Item item = new ItemMapper().mapToObject(entity1);
        Item newItem = new ItemMapper().mapToObject(entity2);
        itemService.update(item, newItem);
    }

    @Override
    public void delete(ItemDto entity) {
        Item item = new ItemMapper().mapToObject(entity);
        itemService.delete(item);
    }
}
