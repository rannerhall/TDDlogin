package com.test.login.logintest.Validation;

import com.test.login.logintest.Token.Token;
import com.test.login.logintest.Token.TokenService;
import com.test.login.logintest.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AuthenticationServiceTest {
    private User user;
    private String username;
    private String password;
    private String permission;
    private String resource;
    private AuthenticationService authenticationService;
    private TokenService tokenService;


    @BeforeEach
    void setUp(){
        permission = "WRITE";
        resource = "ACCOUNT";
        username = "kalle";
        password = "123133";
        user = new User(username, password);
        authenticationService = new AuthenticationService();
        tokenService = new TokenService();
    }

    @Test
    void name() {
        Token token = tokenService.createValidToken();

        assertTrue(authenticationService.verifyWichRightsTheCuntHave());
    }
}