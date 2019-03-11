package restaurant.dto.impl;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import restaurant.dto.EntityDto;

import java.util.Objects;

public final class UserDto implements EntityDto {
    private Integer id;
    private String login;
    private String password;

    public UserDto() {
    }

    public UserDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Contract(pure = true)
    public String getLogin() {
        return login;
    }

    @Contract("_ -> this")
    public UserDto setLogin(String login) {
        this.login = login;
        return this;
    }

    @Contract(pure = true)
    public String getPassword() {
        return password;
    }

    @Contract("_ -> this")
    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    @Contract(pure = true)
    public Integer getId() {
        return id;
    }

    @Contract("_ -> this")
    public UserDto setId(Integer id) {
        this.id = id;
        return this;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return Objects.equals(login, userDto.login) &&
                Objects.equals(password, userDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @NotNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDto{");
        sb.append("login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
