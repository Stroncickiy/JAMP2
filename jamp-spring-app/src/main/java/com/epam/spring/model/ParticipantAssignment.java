package com.epam.spring.model;

import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ToString(of = {"id", "assignee", "role", "status"})
@EqualsAndHashCode(of = {"id"})
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
    @ManyToMany(mappedBy = "participants")
    private List<MentorshipGroup> groups;

}
