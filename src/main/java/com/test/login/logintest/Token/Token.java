package com.test.login.logintest.Token;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Token {
    private String token;

    Token(String token) {
        this.token = token;
    }

    public boolean tokenIsPresent() {
        return token != null;
    }

}
