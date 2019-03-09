package restaurant.entity;

public abstract class Entity<ID> {
    private ID id;

    public ID getId() {
        return id;
    }

    public Entity<ID> setId(ID id) {
        this.id = id;
        return this;
    }
}
