package com.epam.spring.model;

import com.epam.spring.enums.GroupStatus;
import com.epam.spring.enums.ParticipantRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.collection.internal.PersistentList;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@ToString(of = {"id", "mentor", "mentee"})
@EqualsAndHashCode(of = {"id"})
@Entity
public class MentorshipGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
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
