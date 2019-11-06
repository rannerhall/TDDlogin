package com.test.login.logintest.User;


import java.util.ArrayList;
import java.util.List;

public class UsernameAndPasswordList {
    List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public UsernameAndPasswordList() { }

    public void populateUserList() {
        users.add(new User("Anna", "losen"));
        users.add(new User("Berit", "123456"));
        users.add(new User("Kalle", "password"));
    }

    public boolean checkIfUserAndPasswordMatchUserInList(String username, String password) {
        boolean result = false;
        for(User user : users) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password)) {
                result = true;
                break;
            }
        } return result;
    }
}
