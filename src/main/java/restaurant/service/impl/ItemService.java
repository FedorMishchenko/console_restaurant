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

        try {
            return itemDao.find(entity);
        }catch (Exception e){
            throw new MyApplicationException(e);
        }
    }

    @Override
    public void update(Item entity1, Item entity2) {
        try {
            itemDao.update(entity1, entity2);
        }catch (Exception e){
            throw new MyApplicationException(e);
        }
    }

    @Override
    public void delete(Item entity) {
        try {
            itemDao.delete(entity);
        }catch (Exception e){
            throw new MyApplicationException(e);
        }
    }
}
