package com.epam.spring.model;

import com.epam.spring.enums.ActionType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@ToString
public class UserAction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ActionType actionType;
    private String email;
    private boolean success;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    private String session;

    @PrePersist
    public void prePersist() {
        timestamp = new Date();
    }

    @Builder
    public static UserAction createUserAction(ActionType actionType, String email, boolean success, String session) {
        UserAction userAction = new UserAction();
        userAction.setActionType(actionType);
        userAction.setEmail(email);
        userAction.setSession(session);
        userAction.setSuccess(success);
        return userAction;
    }
}
