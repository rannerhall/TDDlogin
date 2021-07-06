package com.test.login.logintest.User;

import com.test.login.logintest.Utils.Permission;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Objects;

@Getter
@Setter
public class User {
    private String username;
    private String password;
    private Permission permissions;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.permissions = new Permission();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return username.equals(that.getUsername()) &&
                password.equals(that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
