package com.test.login.logintest.Login;

import com.test.login.logintest.Token.Token;
import com.test.login.logintest.Token.TokenService;
import com.test.login.logintest.User.UsernameAndPasswordList;

import java.util.Optional;

public class Login {
    private UsernameAndPasswordList usersList;
    private TokenService tokenService = new TokenService();

    public Login() {
    }

    public Optional<Token> validateLogin(String username, String password) {
        if (true) {
            return tokenService.createValidToken();
        } else return Optional.empty();
    }


}
