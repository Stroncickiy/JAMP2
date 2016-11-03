package com.epam.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString(of = {"id", "title", "location"})
@EqualsAndHashCode(of = {"id"})
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
    @OneToMany(mappedBy = "phase", fetch = FetchType.LAZY)
    private List<ParticipantAssignment> participants;
    @OneToMany(mappedBy = "phase", fetch = FetchType.LAZY)
    private List<MentorshipGroup> groups;
    @OneToMany(mappedBy = "phase", fetch = FetchType.LAZY)
    private List<Lecture> lectures;

}
