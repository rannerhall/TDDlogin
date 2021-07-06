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
    private static final String USERNAME = "Kalle";
    private static final String PASSWORD = "password";
    private final UsernameAndPasswordList usernameAndPasswordList = new UsernameAndPasswordList();
    private final Login login = new Login(usernameAndPasswordList);

    @BeforeEach
    void setUpUserAndLogin() { ;
        List<User> users = Arrays.asList(
                new User("Anna", "losen"),
                new User("Berit", "123456"),
                new User(USERNAME, PASSWORD)
        );
        usernameAndPasswordList.setUsers(users);
    }

    @Test
    void validate_login_success() {
        assertTrue(login.validateLogin(USERNAME, PASSWORD).tokenIsPresent());
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
            login.validateLogin(USERNAME, "2");
        });
    }

    @Test
    void validate_login_incorrect_username_fail() {
        assertThrows(RuntimeException.class, () -> {
            login.validateLogin("Kallle", "123311231");
        });
    }
}
