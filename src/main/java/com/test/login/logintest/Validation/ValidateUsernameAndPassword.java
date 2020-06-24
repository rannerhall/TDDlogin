package com.test.login.logintest.Validation;

import com.nimbusds.oauth2.sdk.util.StringUtils;
import com.test.login.logintest.User.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUsernameAndPassword {
    private final int MIN_LENGTH_USERNAME = 4;
    private final int MAX_LENGTH_USERNAME = 12;
    private final int MAX_LENGHT_PASSWORD = 20;
    private User user;

    ValidateUsernameAndPassword(User user) {
        this.user = user;
    }

    public boolean validateUsername() {
        if (StringUtils.isNotBlank(user.getUsername())) {
            return user.getUsername().length() >= MIN_LENGTH_USERNAME && user.getUsername().length() <= MAX_LENGTH_USERNAME;
        } else return false;
    }

    public boolean validatePassword() {
        if (StringUtils.isNotBlank(user.getPassword())) {
            if (user.getPassword().length() <= MAX_LENGHT_PASSWORD) {
                return validatePasswordRegex();
            }
        }
        return false;
    }

    public boolean validatePasswordRegex() {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        CharSequence inputStr = user.getPassword();
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }
}
