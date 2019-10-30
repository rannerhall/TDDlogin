package com.test.login.logintest;


import java.util.ArrayList;
import java.util.List;

class UsernameAndPasswordList {

    static List<ValidateUsernameAndPassword> populateUserList() {
        List<ValidateUsernameAndPassword> users = new ArrayList<>();
        users.add(new ValidateUsernameAndPassword("anna", "losen"));
        users.add(new ValidateUsernameAndPassword("berit", "123456"));
        users.add(new ValidateUsernameAndPassword("kalle", "password"));
        return users;
    }
}
