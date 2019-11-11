package com.test.login.logintest.Utils;

import com.test.login.logintest.Token.Token;
import com.test.login.logintest.Token.TokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RequestPermissionServiceTest {
    private RequestPermissionService requestPermissionService = new RequestPermissionService();
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
    void name() {
        assertTrue(requestPermissionService.returnPermissionOfUser("ACCOUNT", token).contains("READ"));
    }
}