package com.test.login.logintest.Validation;

import com.nimbusds.oauth2.sdk.util.StringUtils;
import com.test.login.logintest.User.User;

import javax.inject.Inject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUsernameAndPassword {
    private final User user;

    @Inject
    ValidateUsernameAndPassword(User user) {
        this.user = user;
    }

    public boolean validateUsername() {
        if (StringUtils.isNotBlank(user.getUsername())) {
            int minLengthUsername = 4;
            int maxLengthUsername = 12;
            return user.getUsername().length() >= minLengthUsername && user.getUsername().length() <= maxLengthUsername;
        } else return false;
    }

    public boolean validatePassword() {
        if (StringUtils.isNotBlank(user.getPassword())) {
            int maxLengthPassword = 20;
            if (user.getPassword().length() <= maxLengthPassword) {
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
