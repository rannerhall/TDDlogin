package com.test.login.logintest.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TokenService {
    List<Optional<Token>> tokenList = new ArrayList<>();

  public  Optional<Token> createValidToken() {
        String uuid = UUID.randomUUID().toString();
        Token token = new Token(uuid);
        if(!uuid.isBlank()){
            addToTokenList(Optional.of(token));
            return Optional.of(token);
        }
        return Optional.empty();
    }


    private void addToTokenList(Optional<Token> token) {
        tokenList.add(token);
    }
}
