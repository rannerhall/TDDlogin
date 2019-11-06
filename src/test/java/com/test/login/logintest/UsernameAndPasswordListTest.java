package com.test.login.logintest;

import com.test.login.logintest.User.User;
import com.test.login.logintest.User.UsernameAndPasswordList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UsernameAndPasswordListTest {
    private Object[] expectedUsers = new Object[3];
    private UsernameAndPasswordList userList;
    private List<User> users;

    @BeforeEach
    void setUpUserList() {
        userList = mock(UsernameAndPasswordList.class);
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
        when(userList.getUsers()).thenReturn(users);
        assertArrayEquals(expectedUsers, userList.getUsers().toArray());
    }

    @Test
    void user_list_is_not_correctly_populated() {
        expectedUsers[0] = new User("felnamn", "fellosen");
        expectedUsers[1] = new User("felnamnigen", "fellosenord");
        expectedUsers[2] = new User("felnamnaterigen", "fellosenigen");
        assertNotEquals(expectedUsers, userList.getUsers().toArray());
    }

    @Test
    void user_list_is_null_fail() {
        when(userList.getUsers()).thenReturn(users);
        expectedUsers[0] = null;
        expectedUsers[1] = null;
        expectedUsers[2] = null;
        assertNotEquals(expectedUsers, userList.getUsers().toArray());
    }
}