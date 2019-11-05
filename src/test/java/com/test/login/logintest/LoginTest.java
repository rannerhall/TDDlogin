package com.test.login.logintest;

import com.test.login.logintest.Login.Login;
import com.test.login.logintest.Token.TokenService;
import com.test.login.logintest.Token.Token;
import com.test.login.logintest.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTest {
    private Login login;
    private String username;
    private String password;
    private TokenService tokenService;

    @BeforeEach
    void setUpUserAndLogin() {
        username = "Pelle";
        password = "123123";
        User user = new User(username, password);
        login = new Login();
        tokenService = new TokenService();
    }

    @Test
    void validate_login_success() {
        Optional<Token> loginResult = login.validateLogin("Pelle", "123123");
        assertTrue(loginResult.isPresent());
    }

    @Test
    void validate_login_fail() {
        Optional<Token> loginResult = login.validateLogin("felnamn", "fellosen");
        assertFalse(loginResult.isPresent());
    }

    @Test
    void validate_login_incorrect_password_fail() {
        Optional<Token> loginResult = login.validateLogin("Pelle", "2");
        assertFalse(loginResult.isPresent());
    }

    @Test
    void validate_login_incorrect_username_fail() {
        Optional<Token> loginResult = login.validateLogin("Peeeeeeeeeeeeeteeeeeeeeeeer", "123311231");
        assertFalse(loginResult.isPresent());
    }

}