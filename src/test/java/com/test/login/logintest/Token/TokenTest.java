package com.test.login.logintest.Token;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class TokenTest {
    private Token token;

    @BeforeEach
    void setUpToken(){
        token = new Token();
    }

    @Test
    void if_token_is_not_unique_fail() {
        String uuidToken1 = token.createValidToken();
        String uuidToken2 = token.createValidToken();
        assertNotEquals(uuidToken1, uuidToken2);
    }

    @Test
    void checks_that_token_is_created_and_has_string_value() {
        String uuid = token.createValidToken();
        Optional<String> uuidString = Optional.of(uuid);
        assertSame(uuid, uuidString.get());
    }
}