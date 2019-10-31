package com.test.login.logintest;

import com.test.login.logintest.Utils.PasswordUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.XpathAssertions;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordEncryptionTest {

    String key;
    String password;
    String salt;
    byte[] bytes;
    char[] chars;



    @BeforeEach
    void setUpHashPassword() {
        password = "password";
        salt = PasswordUtils.generateSalt(512).get();
        chars = password.toCharArray();
        bytes = salt.getBytes();
        key = PasswordEncryption.hashPassword(password, salt).get();
    }

    @Test
    void checks_that_returned_value_is_of_correct_type() {
        Optional<String> testResult = PasswordEncryption.hashPassword(password, salt);
        assertTrue(testResult.isPresent());
    }

    @Test
    void fail_if_salt_is_null() {
        salt = null;
        Optional<String> testResult = PasswordEncryption.hashPassword(password, salt);
        assertTrue(testResult.isEmpty());
    }

    @Test
    void fail_if_password_is_null() {
        password = null;
        Optional<String> testResult = PasswordEncryption.hashPassword(password, salt);
        assertTrue(testResult.isEmpty());
    }

    @Test
    void fail_if_password_and_salt_is_null() {
        password = null;
        salt = null;
        Optional<String> testResult = PasswordEncryption.hashPassword(password, salt);
        assertTrue(testResult.isEmpty());
    }

    @Test
    void check_if_password_string_is_converted_to_char_array() {
        assertThat(password.toCharArray(), is(chars));
    }

    @Test
    void check_if_salt_string_is_converted_to_bytes_array() {
        assertThat(salt.getBytes(), is(bytes));
    }

    @Test
    void check_that_validation_of_hashed_password_is_correct() {
        assertTrue(PasswordEncryption.verifyPassword(password, salt, key));
    }

    @Test
    void fail_if_key_is_not_same_as_hashed_password() {
        key = PasswordEncryption.hashPassword("wrongpassword", salt).get();
        assertFalse(PasswordEncryption.verifyPassword(password, salt, key));
    }

    @Test
    void fail_if_hashed_password_is_not_same_as_key() {
        password = "wrongpassword";
        assertFalse(PasswordEncryption.verifyPassword(password, salt, key));
    }

    @Test
    void fail_if_not_correct_salt_for_specific_password() {
        salt = PasswordUtils.generateSalt(512).get();
        assertFalse(PasswordEncryption.verifyPassword(password, salt, key));
    }
}