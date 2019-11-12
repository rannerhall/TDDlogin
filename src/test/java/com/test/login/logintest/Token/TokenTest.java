package com.test.login.logintest.Token;

import com.test.login.logintest.User.User;
import com.test.login.logintest.Utils.PermissionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TokenTest {
    private TokenService tokenService;
    private User user;
    private PermissionUtils permissions;

    @BeforeEach
    void setUpToken() {
        tokenService = new TokenService();
        permissions = new PermissionUtils();
        permissions.setResource("ACCOUNT");
        permissions.setScope("READ");
        user = new User("Anna", "losen");
        user.setPermissions(permissions);
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

    @Test
    void token_permissions_matches_user_permissions() {
        Token token = tokenService.createValidToken();
        token.setPermissions(user.getPermissions());
        assertThat(user.getPermissions(), is(token.getPermissions()));
    }
}