package com.test.login.logintest.Utils;

import com.test.login.logintest.Token.Token;

import java.util.List;

class AuthenticationService {

    List<String> returnPermissionOfUser(String resource, Token token) {
        if (token.tokenIsPresent()) {
            if (token.getPermissions().getResource().equals(resource)) {
                return token.getPermissions().getScope();
            }
        }
        throw new RuntimeException();
    }
}
