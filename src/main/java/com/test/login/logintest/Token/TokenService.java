package com.test.login.logintest.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class TokenService {
    private List<Token> tokenList = new ArrayList<>();

    public Token createValidToken() {
        String uuid = UUID.randomUUID().toString();
        Token token = new Token(uuid);
        if (!uuid.isBlank()) {
            addTokenToList(token);
            return token;
        }
        throw new RuntimeException();
    }

    private void addTokenToList(Token token) {
        tokenList.add(token);
    }

    boolean authenticateToken(Token token) {
        boolean result = false;
        for (Token t : tokenList) {
            if (token.getToken().equals(t.getToken())) {
                result = true;
                break;
            }
        }
        return result;
    }
}
