package com.test.login.logintest.Password;

import com.test.login.logintest.Utils.PasswordUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PasswordEncryptionTest {
    private String key;
    private String password;
    private String salt;
    private PasswordEncryption passwordEncryption = new PasswordEncryption();

    @BeforeEach
    void setUpHashPassword() throws InvalidKeySpecException, NoSuchAlgorithmException {
        password = "password";
        salt = PasswordUtils.generateSalt(512).get();
        key = passwordEncryption.hashPassword(password, salt).get();
    }

    @Test
    void checks_that_returned_value_is_of_correct_type() throws InvalidKeySpecException, NoSuchAlgorithmException {
        Optional<String> testResult = passwordEncryption.hashPassword(password, salt);
        assertTrue(testResult.isPresent());
    }

    @Test
    void fail_if_salt_is_null() throws InvalidKeySpecException, NoSuchAlgorithmException {
        salt = null;
        Optional<String> testResult = passwordEncryption.hashPassword(password, salt);
        assertTrue(testResult.isEmpty());
    }

    @Test
    void fail_if_password_is_null() throws InvalidKeySpecException, NoSuchAlgorithmException {
        password = null;
        Optional<String> testResult = passwordEncryption.hashPassword(password, salt);
        assertTrue(testResult.isEmpty());
    }

    @Test
    void fail_if_password_and_salt_is_null() throws InvalidKeySpecException, NoSuchAlgorithmException {
        password = null;
        salt = null;
        Optional<String> testResult = passwordEncryption.hashPassword(password, salt);
        assertTrue(testResult.isEmpty());
    }

    @Test
    void check_that_validation_of_hashed_password_is_correct() throws InvalidKeySpecException, NoSuchAlgorithmException {
        assertTrue(passwordEncryption.verifyPassword(password, salt, key));
    }

    @Test
    void fail_if_key_is_not_same_as_hashed_password() throws InvalidKeySpecException, NoSuchAlgorithmException {
        key = passwordEncryption.hashPassword("wrongpassword", salt).get();
        assertFalse(passwordEncryption.verifyPassword(password, salt, key));
    }

    @Test
    void fail_if_hashed_password_is_not_same_as_key() throws InvalidKeySpecException, NoSuchAlgorithmException {
        password = "wrongpassword";
        assertFalse(passwordEncryption.verifyPassword(password, salt, key));
    }

    @Test
    void fail_if_not_correct_salt_for_specific_password() throws InvalidKeySpecException, NoSuchAlgorithmException {
        salt = PasswordUtils.generateSalt(512).get();
        assertFalse(passwordEncryption.verifyPassword(password, salt, key));
    }

    @Test
    void check_that_a_NoSuchAlgorithm_Exception_will_throw_with_not_valid_algorithm() {
        passwordEncryption.setALGORITHM("");
        assertThrows(NoSuchAlgorithmException.class, () -> {
            passwordEncryption.hashPassword(password, salt);
        });
    }
}