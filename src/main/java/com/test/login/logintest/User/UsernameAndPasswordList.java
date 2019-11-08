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

    public UsernameAndPasswordList() { }

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
