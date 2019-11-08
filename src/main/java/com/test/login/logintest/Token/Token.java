package com.test.login.logintest.Token;

public class Token {

    private String token;

    public String getToken() {
        return token;
    }

    Token(String token) {
        this.token = token;
    }

    public boolean tokenIsPresent() {
        return token != null && token.getClass().equals(String.class);
    }

}
