package com.test.login.logintest;

import com.test.login.logintest.Login.Login;
import com.test.login.logintest.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTest {
    private Login login;

    @BeforeEach
    void setUpUserAndLogin() {
        String username = "Pelle";
        String password = "123123";
        User user = new User(username, password);
        login = new Login(user);
    }

    @Test
    void validate_login_success() {
        boolean loginResult = login.validateLogin("Pelle", "123123");
        assertTrue(loginResult);
    }

    @Test
    void validate_login_fail() {
    boolean loginResult = login.validateLogin("felnamn", "fellosen");
    assertFalse(loginResult);
    }

    @Test
    void validate_login_incorrect_password_fail() {
        boolean loginResult = login.validateLogin("Pelle", "2");
        assertFalse(loginResult);
    }

    @Test
    void validate_login_incorrect_username_fail() {
        boolean loginResult = login.validateLogin("Peeeeeeeeeeeeeteeeeeeeeeeer", "123311231");
        assertFalse(loginResult);
    }
}