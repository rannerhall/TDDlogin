package com.test.login.logintest.User;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
@Setter
public class UsernameAndPasswordList {
    private List<User> users;

    public boolean checkIfUserAndPasswordMatchUserInList(String username, String password) {
        boolean result = false;
        for (User user : users) {
            if (username.equals(user.getUsername()) &&
                    password.equals(user.getPassword())) {
                result = true;
                break;
            }
        }
        return result;
    }

    public User getUserFromList(String username) {
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                return user;
            }
        }
        throw new RuntimeException();
    }
}
