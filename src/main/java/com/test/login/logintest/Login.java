package com.test.login.logintest;

class Login {

    boolean validateLogin(String username, String password, UsernameAndPassword user) {
        return username.equals(user.getUsername()) && password.equals(user.getPassword());
    }
}
