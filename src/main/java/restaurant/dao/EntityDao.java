package restaurant.dao;


public interface EntityDao<T> {

void create(T entity);
T find(T entity);
void  update(T entity1, T entity2);
void delete(T entity);

}
