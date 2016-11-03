package com.epam.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.epam.spring.enums.ActionType;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class UserAction implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6560304855041153683L;
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
