package com.test.login.logintest;

import com.test.login.logintest.Login.Login;
import com.test.login.logintest.Token.TokenService;
import com.test.login.logintest.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LoginTest {
    private Login login;
    private String username;
    private String password;
    private TokenService tokenService;
    private List<User> users;





    @BeforeEach
    void setUpUserAndLogin() {
        username = "Kalle";
        password = "password";
        login = new Login();
        tokenService = new TokenService();
        users = Arrays.asList(
                new User("Anna", "losen"),
                new User("Berit", "123456"),
                new User("Kalle", "password")
        );
    }

    @Test
    void validate_login_success() {
        login = mock(Login.class);
        when(login.validateLogin(username, password)).thenReturn(tokenService.createValidToken());
        assertTrue(login.validateLogin(username, password).tokenIsPresent());
    }

    @Test
    void validate_login_fail() {
        assertThrows(RuntimeException.class, () -> {
            login.validateLogin("felnamn", "fellosen");
        });
    }

    @Test
    void validate_login_incorrect_password_fail() {
        assertThrows(RuntimeException.class, () -> {
            login.validateLogin(username, "2");
        });    }

    @Test
    void validate_login_incorrect_username_fail() {
        assertThrows(RuntimeException.class, () -> {
            login.validateLogin("Kallle", "123311231");
        });
    }

}