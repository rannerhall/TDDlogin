package com.test.login.logintest.Utils;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;

public class PasswordUtils {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static Optional<String> generateSalt(int length) {
        if (length < 1) {
            return Optional.empty();
        }
        byte[] salt = new byte[length];
        SECURE_RANDOM.nextBytes(salt);
        return Optional.of(Base64.getEncoder().encodeToString(salt));
    }
}
