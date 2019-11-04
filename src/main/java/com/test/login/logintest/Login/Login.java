package com.test.login.logintest.Login;

import com.test.login.logintest.User.User;

public class Login {
    private User user;

    public Login(User user) {
        this.user = user;
    }

    public boolean validateLogin(String username, String password) {
        return username.equals(user.getUsername()) && password.equals(user.getPassword());
    }
}
