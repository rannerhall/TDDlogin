package com.test.login.logintest.Utils;

import com.test.login.logintest.Token.Token;
import com.test.login.logintest.Token.TokenService;
import com.test.login.logintest.User.User;
import com.test.login.logintest.User.UsernameAndPasswordList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AuthenticationServiceTest {
    private Token token;
    private TokenService tokenService = new TokenService();
    private UsernameAndPasswordList usernameAndPasswordList = new UsernameAndPasswordList();
    private AuthenticationService authenticationService = new AuthenticationService(usernameAndPasswordList, tokenService);
    private Permission permission = new Permission();
    private User user = new User("Anna", "losen");
    private List<User> userlist = new ArrayList<>();
    private HashMap<Token, String> tokenList = new HashMap<>();

    @BeforeEach
    void setUp() {
        permission.setResource("ACCOUNT");
        permission.setScope("READ");
        user.setPermissions(permission);
        token = tokenService.createValidToken(user.getUsername());
        userlist.add(user);
        usernameAndPasswordList.setUsers(userlist);
        tokenList.put(token, user.getUsername());
        tokenService.setTokenList(tokenList);
    }

    @Test
    void token_has_resource_and_scope_success() {
        assertTrue(authenticationService.returnPermissionOfUser("ACCOUNT", token).contains("READ"));
    }

    @Test
    void token_has_not_resource_and_scope_throws_new_runtime_exception() {
        assertThrows(RuntimeException.class, () -> {
            authenticationService.returnPermissionOfUser("", token).contains("");
        });
    }
}