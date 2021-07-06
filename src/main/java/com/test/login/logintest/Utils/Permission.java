package com.test.login.logintest.Utils;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Permission {
    private String resource;
    private final List<String> scope;

    public Permission() {
        this.resource = "";
        this.scope = new ArrayList<>();
    }

    public void setScope(String scope) {
        this.scope.add(scope);
    }
}
