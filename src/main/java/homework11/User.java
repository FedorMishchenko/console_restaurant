package homework11;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.UUID;

public class User {
    private String name;
    private UUID id;
    private String email;
    private int age;
    private long salary;
    private Address address;


    public UUID getId() {return id;}

    public void setId(UUID id) {this.id = id;}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public  long getSalary() {
        return salary;
    }

    public Address getAddress() {
        return address;
    }

    public User(@NotNull Builder builder) {
        this.name = builder.getName();
        this.id = builder.getId();
        this.email = builder.getEmail();
        this.age = builder.getAge();
        this.salary = builder.getSalary();
        this.address = builder.getAddress();

    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age &&
                user.salary == salary &&
                id.equals(user.id) &&
                name.equals(user.name) &&
                email.equals(user.email) &&
                address.equals(user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,id, email, age, salary, address);
    }

    @Override
    public String toString() {
        return "UserDTO[" +
                "id= " + id  +
                ", name=" + name +
                ", email=" + email +
                ", age=" + age +
                ", salary=" + salary +
                ", address: " + this.address.toString();

    }


    static class Builder {
        private String name;
        private String email;
        private int age;
        private long salary;
        private UUID uuid;
        private Address address;

        UUID getId(){return this.uuid;}

        String getName() {
            return this.name;
        }

        String getEmail() {
            return this.email;
        }

        int getAge() {
            return this.age;
        }

        long getSalary() {
            return this.salary;
        }

        Address getAddress(){return this.address;}

        Builder address(Address address){
            this.address = address;
            return this;
        }

        Builder name(String name) {
            this.name = name;
            return this;
        }

        Builder id(UUID id){
            if(uuid!= null){
                this.uuid = id;
            }
            else this.uuid = UUID.randomUUID();
            return this;
        }
        Builder id(){
            return id(null);
        }

        Builder email(String email) {
            this.email = email;
            return this;
        }

        Builder age(int age) {
            this.age = age;
            return this;
        }

        Builder salary(long salary) {
            this.salary = salary;
            return this;
        }
    }


    static class Address {
        private String country;
        private String city;
        private String street;
        private Integer house;
        private Integer flat;

        public Address(String country, String city, String street,
                       Integer house, Integer flat) {
            this.country = country;
            this.city = city;
            this.street = street;
            this.house = house;
            this.flat = flat;
        }

        Address() {

        }

        String getCountry() {
            return country;
        }

        String getCity() {
            return city;
        }

        Address city(String city) {
            this.city = city;
            return this;
        }

        Address country(String country) {
            this.country = country;
            return this;
        }

        String getStreet() {
            return street;
        }

        Address street(String street) {
            this.street = street;
            return this;
        }

        Integer getHouse() {
            return house;
        }

        Address house(Integer house) {
            this.house = house;
            return this;
        }

        Integer getFlat() {
            return flat;
        }

        Address flat(Integer flat) {
            this.flat = flat;
            return this;
        }

        @Contract(value = "null -> false", pure = true)
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Address)) return false;
            Address address = (Address) o;
            return getCountry().equals(address.getCountry()) &&
                    getCity().equals(address.getCity()) &&
                    getStreet().equals(address.getStreet()) &&
                    getHouse().equals(address.getHouse()) &&
                    Objects.equals(getFlat(), address.getFlat());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCountry(),
                    getCity(), getStreet(), getHouse(), getFlat());
        }

        @Override
        public String toString() {
            return  "country=" + getCountry() +
                    ", city=" + getCity()  +
                    ", street=" + getStreet()  +
                    ", house=" + getHouse() +
                    ", flat=" + getFlat() +
                    ']';
        }


    }
}
