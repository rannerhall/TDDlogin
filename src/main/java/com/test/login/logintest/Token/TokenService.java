package com.test.login.logintest.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class TokenService {
    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    List<Token> tokenList = new ArrayList<>();

   /* private static SecretKey secretKey =

    public String tokenBuilder(User user) {
        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .claim("premission", user.getPremission)
                .setExpiration(new Date(System.currentTimeMillis()))
                .signWith(secretKey)
                .compact();

        return token;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    */

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

    public boolean authenticateToken(Token token) {
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
