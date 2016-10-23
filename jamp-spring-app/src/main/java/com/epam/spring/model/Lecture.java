package com.epam.spring.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 5, max = 25)
    private String domainArea;
    @NotNull
    @Size(min = 5, max = 25)
    private String topic;
    @OneToOne
    @NotNull
    private ParticipantAssignment lector;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @ManyToOne
    @NotNull
    private MentorshipPhase phase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomainArea() {
        return domainArea;
    }

    public void setDomainArea(String domainArea) {
        this.domainArea = domainArea;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public ParticipantAssignment getLector() {
        return lector;
    }

    public void setLector(ParticipantAssignment lector) {
        this.lector = lector;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public MentorshipPhase getPhase() {
        return phase;
    }

    public void setPhase(MentorshipPhase phase) {
        this.phase = phase;
    }

}
