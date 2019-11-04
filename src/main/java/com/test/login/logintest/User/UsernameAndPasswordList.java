package com.test.login.logintest.User;


import java.util.ArrayList;
import java.util.List;

public class UsernameAndPasswordList {

    public static List<User> populateUserList() {
        List<User> users = new ArrayList<>();
        users.add(new User("anna", "losen"));
        users.add(new User("berit", "123456"));
        users.add(new User("kalle", "password"));
        return users;
    }
}
