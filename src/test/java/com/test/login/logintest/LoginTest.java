package com.test.login.logintest;

import com.test.login.logintest.Login.Login;
import com.test.login.logintest.Token.Token;
import com.test.login.logintest.Token.TokenService;
import com.test.login.logintest.User.UsernameAndPasswordList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class LoginTest {
    private Login login;
    private String username;
    private String password;
    private TokenService tokenService;
    private UsernameAndPasswordList userList = new UsernameAndPasswordList();



    @BeforeEach
    void setUpUserAndLogin() {
        login = mock(Login.class);
        username = "Kalle";
        password = "password";
        login = new Login();
        tokenService = new TokenService();
        userList.populateUserList();
    }

    @Test
    void validate_login_success() {
        Token loginResult = login.validateLogin(username, password);
        assertTrue(loginResult.tokenIsPresent());
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