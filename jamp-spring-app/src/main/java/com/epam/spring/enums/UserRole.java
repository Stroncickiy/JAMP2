package com.epam.spring.enums;

public enum UserRole {
    ADMIN, CLIENT;

    public String getTitle() {
        return name();
    }
}
