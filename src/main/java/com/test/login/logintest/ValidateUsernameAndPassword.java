package com.test.login.logintest;

import com.nimbusds.oauth2.sdk.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ValidateUsernameAndPassword {
    private final int MIN_LENGTH_USERNAME = 4;
    private final int MAX_LENGTH_USERNAME = 12;
    private final int MIN_LENGHT_PASSWORD = 6;
    private final int MAX_LENGHT_PASSWORD = 20;
    private String username;
    private String password;

    ValidateUsernameAndPassword(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    boolean validateUsername() {
        if (StringUtils.isNotBlank(username)) {
            return username.length() >= MIN_LENGTH_USERNAME && username.length() <= MAX_LENGTH_USERNAME;
        } else return false;
    }

    boolean validatePassword() {
        if (StringUtils.isNotBlank(password)) {
            if (password.length() <= MAX_LENGHT_PASSWORD) {
               return validatePasswordRegex();
            }
        }
        return false;
    }

    boolean validatePasswordRegex() {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        CharSequence inputStr = password;
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }
}
