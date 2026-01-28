package com.advancedSelenium.Enums;

public enum GrantType {
    CLIENT_CREDENTIALS(new String("client_credentials")),
    PASSWORD(new String("password"));

    private final String value;

    GrantType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
