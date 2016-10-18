package com.epam.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class UnsubscribeRQ implements Serializable {
    private User targetUser;
    private List<String> topics;

    public UnsubscribeRQ(User user, String... topics) {
        this.targetUser = user;
        this.topics = Arrays.asList(topics);
    }

    public User getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(User targetUser) {
        this.targetUser = targetUser;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }
}
