package com.test.login.logintest.Utils;

import com.test.login.logintest.Token.Token;
import com.test.login.logintest.Token.TokenService;
import com.test.login.logintest.User.User;
import com.test.login.logintest.User.UsernameAndPasswordList;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

@Service
class AuthenticationService {
    private final UsernameAndPasswordList usernameAndPasswordList;
    private final TokenService tokenService;

    @Inject
    public AuthenticationService(UsernameAndPasswordList usernameAndPasswordList, TokenService tokenService) {
        this.usernameAndPasswordList = usernameAndPasswordList;
        this.tokenService = tokenService;
    }

    List<String> returnPermissionOfUser(String resource, Token token) {
        HashMap<Token, String> tokenList = tokenService.getTokenList();
        String usernameFromToken = tokenList.get(token);
        User user = usernameAndPasswordList.getUserFromList(usernameFromToken);
        if (user != null) {
            if (resource.equals(user.getPermissions().getResource())) {
                return user.getPermissions().getScope();
            }
        }
        throw new RuntimeException();
    }
}
