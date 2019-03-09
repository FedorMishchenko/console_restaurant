package restaurant.controller;


public interface Controller<T, I>
{
        void post(T entity); //create
        T get(T entity); //get
        void put(T entity, T newEntity);
        void delete(T entity); //delete
}
