package com.test.login.logintest.Token;

import com.test.login.logintest.User.User;
import com.test.login.logintest.Utils.Permission;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TokenTest {
    private User user;
    private TokenService tokenService = new TokenService();
    private Permission permissions = new Permission();

    @BeforeEach
    void setUpToken() {
        permissions.setResource("ACCOUNT");
        permissions.setScope("READ");
        user = new User("Anna", "losen");
        user.setPermissions(permissions);
    }

    @Test
    void if_token_is_not_unique_fail() {
        Token uuidToken1 = tokenService.createValidToken(user.getUsername());
        Token uuidToken2 = tokenService.createValidToken(user.getUsername());
        assertNotEquals(uuidToken1, uuidToken2);
    }

    @Test
    void tests_that_token_is_created() {
        Token uuid = tokenService.createValidToken(user.getUsername());
        assertTrue(uuid.tokenIsPresent());
    }
}
