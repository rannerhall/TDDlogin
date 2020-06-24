package com.test.login.logintest.Password;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

public class PasswordEncryption {
    private int ITERATIONS;
    private int KEY_LENGTH;
    private String ALGORITHM;

    public void setALGORITHM(String ALGORITHM) {
        this.ALGORITHM = ALGORITHM;
    }

    public PasswordEncryption() {
        this.ALGORITHM = "PBKDF2WithHmacSHA512";
        this.ITERATIONS = 65536;
        this.KEY_LENGTH = 512;
    }

    public Optional<String> hashPassword(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (password == null || salt == null) {
            System.err.println("Parameters password or salt in hashPassword can´t be null");
            return Optional.empty();
        }

        char[] chars = password.toCharArray();
        byte[] bytes = salt.getBytes();

        PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

        Arrays.fill(chars, Character.MIN_VALUE);

        try {
            SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] securePassword = fac.generateSecret(spec).getEncoded();
            return Optional.of(Base64.getEncoder().encodeToString(securePassword));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.err.println("Exception encountered in hashPassword()");
            throw ex;
        } finally {
            spec.clearPassword();
        }
    }

    public boolean verifyPassword(String password, String salt, String key) throws InvalidKeySpecException, NoSuchAlgorithmException {
        Optional<String> hashedPassword = hashPassword(password, salt);
        if (!hashedPassword.get().equals(key)) {
            return false;
        }
        hashedPassword.get();
        return true;
    }
}
