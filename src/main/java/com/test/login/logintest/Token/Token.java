package com.test.login.logintest.Token;

public class Token {
    private String token;

    Token(String token) {
        this.token = token;
    }

    String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean tokenIsPresent() {
        return token != null && token.getClass().equals(String.class);
    }

}
