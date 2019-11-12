package com.test.login.logintest.Login;

import com.test.login.logintest.Token.TokenService;
import com.test.login.logintest.User.User;
import com.test.login.logintest.User.UsernameAndPasswordList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTest {
    private String username;
    private String password;
    private TokenService tokenService;
    private List<User> users;
    private Login login;
    private UsernameAndPasswordList usernameAndPasswordList = new UsernameAndPasswordList();

    @BeforeEach
    void setUpUserAndLogin() {
        username = "Kalle";
        password = "password";
        tokenService = new TokenService();
        users = Arrays.asList(
                new User("Anna", "losen"),
                new User("Berit", "123456"),
                new User("Kalle", "password")
        );
        usernameAndPasswordList.setUsers(users);
        login = new Login(usernameAndPasswordList);
    }

    @Test
    void validate_login_success() {
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
        });
    }

    @Test
    void validate_login_incorrect_username_fail() {
        assertThrows(RuntimeException.class, () -> {
            login.validateLogin("Kallle", "123311231");
        });
    }
}