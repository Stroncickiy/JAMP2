package com.epam.spring.model;

import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ParticipantAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @NotNull
    private User assignee;
    @NotNull
    private ParticipantRole role;
    @Enumerated(EnumType.STRING)
    @NotNull
    private ParticipantStatus status;
    @ManyToOne
    @NotNull
    private MentorshipPhase phase;

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public ParticipantRole getRole() {
        return role;
    }

    public void setRole(ParticipantRole role) {
        this.role = role;
    }

    public ParticipantStatus getStatus() {
        return status;
    }

    public void setStatus(ParticipantStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MentorshipPhase getPhase() {
        return phase;
    }

    public void setPhase(MentorshipPhase phase) {
        this.phase = phase;
    }

}
