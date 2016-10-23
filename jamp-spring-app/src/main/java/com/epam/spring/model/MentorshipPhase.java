package com.epam.spring.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class MentorshipPhase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 5, max = 30)
    private String title;
    @NotNull
    @Size(min = 4, max = 15)
    private String location;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @OneToMany(mappedBy = "phase")
    private List<ParticipantAssignment> participants;
    @OneToMany(mappedBy = "phase")
    private List<MentorshipGroup> groups;
    @OneToMany(mappedBy = "phase")
    private List<Lecture> lectures;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MentorshipGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<MentorshipGroup> groups) {
        this.groups = groups;
    }

    public List<ParticipantAssignment> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantAssignment> participants) {
        this.participants = participants;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

}
