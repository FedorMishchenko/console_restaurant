package restaurant.entity;

public class Item extends Entity<Integer> {
    private String item;
    private String price;
    private Integer id;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Entity<Integer> setId(Integer id) {
        this.id = id;
        return this;
    }
}
