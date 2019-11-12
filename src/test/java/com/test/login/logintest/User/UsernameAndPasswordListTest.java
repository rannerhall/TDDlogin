package com.test.login.logintest.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsernameAndPasswordListTest {
    private Object[] expectedUsers = new Object[3];
    private UsernameAndPasswordList userList = new UsernameAndPasswordList();
    private List<User> users;

    @BeforeEach
    void setUpUserList() {
        expectedUsers[0] = new User("Anna", "losen");
        expectedUsers[1] = new User("Berit", "123456");
        expectedUsers[2] = new User("Kalle", "password");
        users = Arrays.asList(
                new User("Anna", "losen"),
                new User("Berit", "123456"),
                new User("Kalle", "password")
        );
    }

    @Test
    void user_list_is_correctly_populated() {
        assertArrayEquals(expectedUsers, users.toArray());
    }

    @Test
    void user_list_is_not_correctly_populated() {
        expectedUsers[0] = new User("felnamn", "fellosen");
        expectedUsers[1] = new User("felnamnigen", "fellosenord");
        expectedUsers[2] = new User("felnamnaterigen", "fellosenigen");
        assertNotEquals(expectedUsers, users.toArray());
    }

    @Test
    void user_list_is_null_fail() {
        expectedUsers[0] = null;
        expectedUsers[1] = null;
        expectedUsers[2] = null;
        assertNotEquals(expectedUsers, users.toArray());
    }

    @Test
    void find_user_in_user_list_by_username_and_password() {
        userList.setUsers(users);
        assertTrue(userList.checkIfUserAndPasswordMatchUserInList("Berit", "123456"));
    }
}