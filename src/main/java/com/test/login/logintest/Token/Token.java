package com.test.login.logintest.Token;

import java.util.UUID;

class Token {
    String createValidToken() {
        return UUID.randomUUID().toString();
    }
}
