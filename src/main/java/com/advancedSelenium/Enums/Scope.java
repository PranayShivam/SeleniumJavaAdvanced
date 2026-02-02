package com.advancedSelenium.Enums;

public enum Scope {

    TRUST("trust");

    private final String value;

    Scope(String value) {
    this.value = value;
    }

    public String getValue() {
        return value;
    }
}
