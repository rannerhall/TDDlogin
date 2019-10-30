package com.test.login.logintest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class ValidateUsernameAndPasswordTest {
    private ValidateUsernameAndPassword user;

    @BeforeEach
    void setUpUser() {
        String username = "Pelle";
        String password = "123123";
        user = new ValidateUsernameAndPassword(username, password);
    }

    @Test
    void username_format_is_valid() {
        assertThat(user.getUsername(), is("Pelle"));
    }

    @Test
    void password_format_is_valid() {
        assertThat(user.getPassword(), is("123123"));
    }

    @Test
    void username_more_or_equal_to_4_and_less_than_12_letters_is_valid(){
        user.setUsername("Pelle");
        assertTrue(user.validateUsername());
    }

    @Test
    void username_less_than_4_letters_is_not_valid() {
        user.setUsername("Pel");
        assertFalse(user.validateUsername());
    }

    @Test
    void username_more_than_12_letters_is_not_valid() {
        user.setUsername("Pellepellepelle");
        assertFalse(user.validateUsername());
    }

    @Test
    void password_more_or_equal_to_8_chars_is_valid() {
        user.setPassword("1Bokstaverna32%");
        assertTrue(user.validatePassword());
    }

    @Test
    void password_is_more_than_20_chars_not_valid() {
        user.setPassword("123456789123456789123");
        assertFalse(user.validatePassword());
    }

    @Test
    void password_has_correct_regex_is_valid() {
        user.setPassword("1Bokstaverna32%");
        assertTrue(user.validatePasswordRegex());
    }

    @Test
    void password_has_incorrect_regex_is_invalid() {
        user.setPassword("Anton e en Tönt");
        assertFalse(user.validatePasswordRegex());
    }
}