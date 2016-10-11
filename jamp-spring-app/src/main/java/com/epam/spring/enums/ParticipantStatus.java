package com.epam.spring.enums;

public enum ParticipantStatus {
    PROPOSED, APPROVED_RM, CONFIRMED_CDP, ON_HOLD, IN_PROGRESS;

    public String getTitle() {
        return name();
    }
}
