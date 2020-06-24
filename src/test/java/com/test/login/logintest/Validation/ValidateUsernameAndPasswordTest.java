package com.test.login.logintest.Validation;

import com.test.login.logintest.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateUsernameAndPasswordTest {
    private User user;
    private ValidateUsernameAndPassword validateUsernameAndPassword;

    @BeforeEach
    void setUpUser() {
        String username = "Pelle";
        String password = "123123";
        user = new User(username, password);
        validateUsernameAndPassword = new ValidateUsernameAndPassword(user);
    }

    @Test
    void username_format_is_valid() {
        assertThat(user.getUsername(), is("Pelle"));
    }

    @Test
    void username_is__empty_not_valid() {
        user.setUsername("");
        assertFalse(validateUsernameAndPassword.validateUsername());
    }

    @Test
    void password_format_is_valid() {
        assertThat(user.getPassword(), is("123123"));
    }

    @Test
    void username_more_or_equal_to_4_and_less_than_12_letters_is_valid() {
        user.setUsername("Pelle");
        assertTrue(validateUsernameAndPassword.validateUsername());
    }

    @Test
    void username_less_than_4_letters_is_not_valid() {
        user.setUsername("Pel");
        assertFalse(validateUsernameAndPassword.validateUsername());
    }

    @Test
    void username_more_than_12_letters_is_not_valid() {
        user.setUsername("Pellepellepelle");
        assertFalse(validateUsernameAndPassword.validateUsername());
    }

    @Test
    void password_more_or_equal_to_8_chars_is_valid() {
        user.setPassword("1Bokstaverna32%");
        assertTrue(validateUsernameAndPassword.validatePassword());
    }

    @Test
    void password_is_more_than_20_chars_not_valid() {
        user.setPassword("123456789123456789123");
        assertFalse(validateUsernameAndPassword.validatePassword());
    }

    @Test
    void password_has_correct_regex_is_valid() {
        user.setPassword("1Bokstaverna32%");
        assertTrue(validateUsernameAndPassword.validatePasswordRegex());
    }

    @Test
    void password_has_incorrect_regex_is_invalid() {
        user.setPassword("fel losen ord");
        assertFalse(validateUsernameAndPassword.validatePasswordRegex());
    }
}
