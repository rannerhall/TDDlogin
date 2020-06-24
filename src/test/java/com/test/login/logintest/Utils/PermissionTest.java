package com.test.login.logintest.Utils;

import com.test.login.logintest.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PermissionTest {
    private Permission permission = new Permission();
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("Berit", "123456");
        permission.setScope("READ");
        permission.setScope("WRITE");
        permission.setResource("ACCOUNT");
    }

    @Test
    void check_if_permissions_is_created() {
        assertTrue(permission.getScope().contains("READ"));
        assertTrue(permission.getScope().contains("WRITE"));
        assertThat(permission.getResource(), is("ACCOUNT"));
    }

    @Test
    void check_if_permissions_is_added_to_user() {
        user.setPermissions(permission);
        assertThat(user.getPermissions(), is(permission));
    }
}
