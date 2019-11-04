package com.test.login.logintest;

import com.test.login.logintest.User.User;
import com.test.login.logintest.User.UsernameAndPasswordList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UsernameAndPasswordListTest {
    private Object[] expectedUsers = new Object[3];

    @BeforeEach
    void setUpUserList() {
        expectedUsers[0] = new User("anna", "losen");
        expectedUsers[1] = new User("berit", "123456");
        expectedUsers[2] = new User("kalle", "password");
    }

    @Test
    void user_list_is_correctly_populated() {
        Object[] testOutput = UsernameAndPasswordList.populateUserList().toArray();
        assertArrayEquals(expectedUsers, testOutput);
    }

    @Test
    void user_list_is_not_correctly_populated() {
        expectedUsers[0] = new User("felnamn", "fellosen");
        expectedUsers[1] = new User("felnamnigen", "fellosenord");
        expectedUsers[2] = new User("felnamnaterigen", "fellosenigen");
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