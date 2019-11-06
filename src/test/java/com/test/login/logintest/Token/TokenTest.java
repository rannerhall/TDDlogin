package com.test.login.logintest.Token;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class TokenTest {
    private TokenService tokenService;
    private TokenService mockedToken;

    @BeforeEach
    void setUpToken() {
        tokenService = new TokenService();
        mockedToken = mock(TokenService.class);
    }

    @Test
    void if_token_is_not_unique_fail() {
        Token uuidToken1 = tokenService.createValidToken();
        Token uuidToken2 = tokenService.createValidToken();
        assertNotEquals(uuidToken1, uuidToken2);
    }

    @Test
    void tests_that_token_is_created() {
        Token uuid = tokenService.createValidToken();
        assertTrue(uuid.tokenIsPresent());
    }

}