package com.test.login.logintest;

class Login {
    private ValidateUsernameAndPassword user;

    Login(ValidateUsernameAndPassword user) {
        this.user = user;
    }

    boolean validateLogin(String username, String password) {
        return username.equals(user.getUsername()) && password.equals(user.getPassword());
    }
}
