package com.test.login.logintest.User;


import java.util.ArrayList;
import java.util.List;

public class UsernameAndPasswordList {
    List<User> users = new ArrayList<>();

    public List<User> populateUserList() {
        users.add(new User("anna", "losen"));
        users.add(new User("berit", "123456"));
        users.add(new User("kalle", "password"));
        return users;
    }
}
