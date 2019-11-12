package com.test.login.logintest.Utils;

import com.test.login.logintest.Token.Token;
import com.test.login.logintest.Token.TokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {
    private AuthenticationService authenticationService = new AuthenticationService();
    private Token token;
    private TokenService tokenService = new TokenService();
    private PermissionUtils permissionUtils = new PermissionUtils();

    @BeforeEach
    void setUp() {
        permissionUtils.setResource("ACCOUNT");
        permissionUtils.setScope("READ");
        token = tokenService.createValidToken();
        token.setPermissions(permissionUtils);
    }

    @Test
    void token_has_resource_and_scope_success() {
        assertTrue(authenticationService.returnPermissionOfUser("ACCOUNT", token).contains("READ"));
    }

    @Test
    void token_har_resource_but_wrong_scope_fail() {
        assertFalse(authenticationService.returnPermissionOfUser("ACCOUNT", token).contains("WRITE"));
    }

    @Test
    void token_has_not_resource_and_scope_throws_new_runtime_exception() {
        assertThrows(RuntimeException.class, () -> {
            authenticationService.returnPermissionOfUser("", token).contains("");
        });
    }
}