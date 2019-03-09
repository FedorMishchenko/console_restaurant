package restaurant.service.impl;

import restaurant.dao.ItemDao;
import restaurant.entity.Item;
import restaurant.exceptions.MyApplicationException;
import restaurant.service.Service;

public class ItemService implements Service<Item> {
    private ItemDao itemDao;
    public ItemService(){
        itemDao = new ItemDao();
    }

    @Override
    public void create(Item entity) {


        try {
            itemDao.create(entity);
        }catch (Exception e){
            throw new MyApplicationException(e);
        }
    }

    @Override
    public Item get(Item entity) {
        return null;
    }

    @Override
    public void update(Item entity1, Item entity2) {

    }

    @Override
    public void delete(Item entity) {

    }
}
