package restaurant.service;

public interface Service<T> {
    void create(T entity);

    T get(T entity);

    void delete(T entity);

    void update(T user, T newUser);
}
