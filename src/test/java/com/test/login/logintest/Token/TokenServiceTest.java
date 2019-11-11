package com.test.login.logintest.Token;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TokenServiceTest {
    private TokenService tokenService = new TokenService();
    private Token token;

    @BeforeEach
    void setUpTokenServiceTest() {
        token = tokenService.createValidToken();
    }

    @Test
    void checks_that_the_token_is_present_in_the_list() {
        assertTrue(tokenService.authenticateToken(token));
    }
}