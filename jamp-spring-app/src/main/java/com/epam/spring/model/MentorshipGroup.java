package com.epam.spring.model;

import com.epam.spring.enums.GroupStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class MentorshipGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @NotNull
    private ParticipantAssignment mentor;
    @OneToOne
    @NotNull
    private ParticipantAssignment mentee;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date plannedStart;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date plannedEnd;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date actualStart;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date actualEnd;
    @Enumerated(EnumType.STRING)
    @NotNull
    private GroupStatus status;
    @ManyToOne
    @NotNull
    private MentorshipPhase phase;

    public ParticipantAssignment getMentor() {
        return mentor;
    }

    public void setMentor(ParticipantAssignment mentor) {
        this.mentor = mentor;
    }

    public ParticipantAssignment getMentee() {
        return mentee;
    }

    public void setMentee(ParticipantAssignment mentee) {
        this.mentee = mentee;
    }

    public Date getPlannedStart() {
        return plannedStart;
    }

    public void setPlannedStart(Date plannedStart) {
        this.plannedStart = plannedStart;
    }

    public Date getPlannedEnd() {
        return plannedEnd;
    }

    public void setPlannedEnd(Date plannedEnd) {
        this.plannedEnd = plannedEnd;
    }

    public Date getActualStart() {
        return actualStart;
    }

    public void setActualStart(Date actualStart) {
        this.actualStart = actualStart;
    }

    public Date getActualEnd() {
        return actualEnd;
    }

    public void setActualEnd(Date actualEnd) {
        this.actualEnd = actualEnd;
    }

    public GroupStatus getStatus() {
        return status;
    }

    public void setStatus(GroupStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPhase(MentorshipPhase phase) {
        this.phase = phase;
    }

    public MentorshipPhase getPhase() {
        return phase;
    }
}
