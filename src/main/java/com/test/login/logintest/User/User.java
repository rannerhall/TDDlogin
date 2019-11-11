package com.test.login.logintest.User;

import com.test.login.logintest.Utils.PermissionUtils;

import javax.persistence.Entity;
import java.security.Permission;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Entity
public class User {
    private String username;
    private String password;
    private PermissionUtils permissions;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.permissions = new PermissionUtils();
    }

    public PermissionUtils getPermissions() {
        return permissions;
    }

    public void setPermissions(PermissionUtils permissions) {
        this.permissions = permissions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
