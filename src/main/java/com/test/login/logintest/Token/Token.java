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
        if(token != null && token.getClass().equals(String.class) ) {
            return true;
        } else return false;
    }

}
