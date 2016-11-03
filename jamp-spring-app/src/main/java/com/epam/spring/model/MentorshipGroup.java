package com.epam.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.epam.spring.enums.GroupStatus;
import com.epam.spring.enums.ParticipantRole;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(of = {"id", "mentor", "mentee"})
@EqualsAndHashCode(of = {"id"})
@Entity
public class MentorshipGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<ParticipantAssignment> participants;
    @Transient
    private ParticipantAssignment mentor;
    @Transient
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

    @PostLoad
    @PostPersist
    @PostUpdate
    private void postPersist() {
        mentor = participants.stream().filter(p -> p.getRole().equals(ParticipantRole.MENTOR)).findFirst().get();
        mentee = participants.stream().filter(p -> p.getRole().equals(ParticipantRole.MENTEE)).findFirst().get();
    }
}
