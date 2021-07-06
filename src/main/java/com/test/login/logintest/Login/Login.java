package com.test.login.logintest.Login;

import com.test.login.logintest.Token.Token;
import com.test.login.logintest.Token.TokenService;
import com.test.login.logintest.User.UsernameAndPasswordList;

import javax.inject.Inject;

public class Login {
    private final UsernameAndPasswordList userList;
    private final TokenService tokenService = new TokenService();

    @Inject
    public Login(UsernameAndPasswordList userList) {
        this.userList = userList;
    }

    public Token validateLogin(String username, String password) {
        if (userList.checkIfUserAndPasswordMatchUserInList(username, password)) {
            return tokenService.createValidToken(username);
        } else throw new RuntimeException();
    }
}
