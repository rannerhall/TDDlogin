package com.test.login.logintest.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermissionUtils {
    private String resource;
    private List<String> scope;
    private HashMap<String, ArrayList> permissionsHashMap;

    public PermissionUtils() {
        this.resource = "";
        this.scope = new ArrayList<>();
    }

    String getResource() {
        return resource;
    }

    void setResource(String resource) {
        this.resource = resource;
    }

    List<String> getScope() {
        return scope;
    }

    void setScope(String scope) {
        this.scope.add(scope);
    }
}
