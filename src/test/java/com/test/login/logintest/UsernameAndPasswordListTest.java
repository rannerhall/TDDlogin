package com.test.login.logintest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsernameAndPasswordListTest {
    Object[] expectedUsers = new Object[3];

    @BeforeEach
    void setUpUserList() {
        expectedUsers[0] = new ValidateUsernameAndPassword("anna", "losen");
        expectedUsers[1] = new ValidateUsernameAndPassword("berit", "123456");
        expectedUsers[2] = new ValidateUsernameAndPassword("kalle", "password");
    }

    @Test
    void user_list_is_correctly_populated() {
        Object[] testOutput = UsernameAndPasswordList.populateUserList().toArray();
        assertArrayEquals(expectedUsers, testOutput);
    }

    @Test
    void user_list_is_not_correctly_populated() {
        expectedUsers[0] = new ValidateUsernameAndPassword("felnamn", "fellosen");
        expectedUsers[1] = new ValidateUsernameAndPassword("felnamnigen", "fellosenord");
        expectedUsers[2] = new ValidateUsernameAndPassword("felnamnaterigen", "fellosenigen");
        Object[] testOutput = UsernameAndPasswordList.populateUserList().toArray();
        assertNotEquals(expectedUsers, testOutput);
    }

    @Test
    void user_list_is_null_fail() {
        expectedUsers[0] = null;
        expectedUsers[1] = null;
        expectedUsers[2] = null;
        Object[] testOutput = UsernameAndPasswordList.populateUserList().toArray();
        assertNotEquals(expectedUsers, testOutput);
    }
}