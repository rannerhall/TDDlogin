package com.test.login.logintest.Login;

import com.test.login.logintest.Token.Token;
import com.test.login.logintest.Token.TokenService;
import com.test.login.logintest.User.UsernameAndPasswordList;

public class Login {
    private UsernameAndPasswordList userList;
    private TokenService tokenService = new TokenService();

    public Login(UsernameAndPasswordList userList) {
        this.userList = userList;
    }

    public Token validateLogin(String username, String password) {
        if (userList.checkIfUserAndPasswordMatchUserInList(username, password)) {
            return tokenService.createValidToken(username);
        } else throw new RuntimeException();
    }
}
