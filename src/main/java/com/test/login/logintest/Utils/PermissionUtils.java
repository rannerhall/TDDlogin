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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public List<String> getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope.add(scope);
    }
}
