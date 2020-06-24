package com.test.login.logintest.User;

import java.util.List;

public class UsernameAndPasswordList {
    List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UsernameAndPasswordList() {
    }

    public boolean checkIfUserAndPasswordMatchUserInList(String username, String password) {
        boolean result = false;
        for (User user : users) {
            if (username.equals(user.getUsername()) &&
                    password.equals(user.getPassword())) {
                result = true;
                break;
            }
        }
        return result;
    }

    public User getUserFromList(String username) {
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                return user;
            }
        }
        throw new RuntimeException();
    }
}
