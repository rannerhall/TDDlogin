package com.test.login.logintest.Utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilsTest {

    private int length;

    @BeforeEach
    void setUpSalt() {
        length = 1;
    }

    @Test
    void generate_salt_length_is_lower_than_1_fail_to_generate_salt() {
        length = 0;
        Optional<String> testResult = PasswordUtils.generateSalt(length);
        assertTrue(testResult.isEmpty());
    }

    @Test
    void generate_salt_length_is_higher_than_1_does_not_return_empty() {
        Optional<String> testResult = PasswordUtils.generateSalt(length);
        assertFalse(testResult.isEmpty());
    }

    @Test
    void checks_that_returned_value_is_of_correct_type() {
        Optional<String> testResult1 = PasswordUtils.generateSalt(length);
        assertTrue(testResult1.isPresent());
    }

    @Test
    void checks_that_salt_does_not_generate_same_value() {
        Optional<String> testResult1 = PasswordUtils.generateSalt(length);
        Optional<String> testResult2 = PasswordUtils.generateSalt(length);
        assertNotEquals(testResult1, testResult2);
    }
}