package com.test.login.logintest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class UsernameAndPasswordListTest {
    private Object[] expectedUsers = new Object[3];

    @BeforeEach
    void setUpUserList() {
        expectedUsers[0] = new ValidateUsernameAndPassword("anna", "losen");
        expectedUsers[1] = new ValidateUsernameAndPassword("berit", "123456");
        expectedUsers[2] = new ValidateUsernameAndPassword("kalle", "password");
    }

    @Test
    void name() {
        Object[] testOutput = UsernameAndPasswordList.populateUserList().toArray();
        assertArrayEquals(expectedUsers, testOutput);
    }
}