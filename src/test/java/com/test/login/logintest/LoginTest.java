package com.test.login.logintest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTest {
    private UsernameAndPassword user;
    private Login login;

    @BeforeEach
    void setUpUserAndLogin() {
        String username = "Pelle";
        String password = "123123";
        login = new Login();
        user = new UsernameAndPassword(username, password);
    }

    @Test
    void validate_login_success() {
       assertTrue(login.validateLogin("Pelle", "123123", user));
    }

    @Test
    void validate_login_incorrect_password_fail() {
        assertFalse(login.validateLogin("Pelle", "2", user));
    }

    @Test
    void validate_login_incorrect_username_fail() {
        assertFalse(login.validateLogin("Peeeeeeeeeeeeeteeeeeeeeeeer", "123311231", user));
    }
}