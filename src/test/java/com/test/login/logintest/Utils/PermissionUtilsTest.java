package com.test.login.logintest.Utils;

import com.test.login.logintest.Token.Token;
import com.test.login.logintest.Token.TokenService;
import com.test.login.logintest.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class PermissionUtilsTest {

    private PermissionUtils permissionUtils = new PermissionUtils();
    private User user;
    private Token token;
    private TokenService tokenService = new TokenService();
    @BeforeEach void setUp() {
        user = new User("Berit", "123456");
        token = tokenService.createValidToken();
        permissionUtils.setScope("READ");
        permissionUtils.setScope("WRITE");
        permissionUtils.setResource("ACCOUNT");
    }

    @Test
    void check_if_permissions_is_created() {
        assertTrue(permissionUtils.getScope().contains("READ"));
        assertTrue(permissionUtils.getScope().contains("WRITE"));
        assertThat(permissionUtils.getResource(), is("ACCOUNT"));
    }

    @Test
    void check_if_permissions_is_added_to_user() {
        user.setPermissions(permissionUtils);
        assertThat(user.getPermissions(), is(permissionUtils));
    }

    @Test
    void check_if_permissions_is_added_to_token() {
        token.setPermissions(permissionUtils);
        assertThat(token.getPermissions(), is(permissionUtils));
    }


}