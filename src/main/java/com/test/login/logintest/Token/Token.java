package com.test.login.logintest.Token;

import com.test.login.logintest.Utils.PermissionUtils;

public class Token {

    private String token;
    private PermissionUtils permissions;

    Token(String token) {
        this.token = token;
        this.permissions = new PermissionUtils();
    }

    String getToken() {
        return token;
    }

    public PermissionUtils getPermissions() {
        return permissions;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setPermissions(PermissionUtils permissions) {
        this.permissions = permissions;
    }

    public boolean tokenIsPresent() {
        return token != null && token.getClass().equals(String.class);
    }

}
