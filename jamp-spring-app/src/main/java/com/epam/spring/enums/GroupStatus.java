package com.epam.spring.enums;

public enum GroupStatus {
    INITIATION, IN_PROGRESS, FINISHED, CANCELED;

    public String getTitle() {
        return name();
    }
}
