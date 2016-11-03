package com.epam.spring.model;

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
import javax.validation.constraints.NotNull;

import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
    @ManyToMany(mappedBy = "participants", fetch = FetchType.LAZY)
    private List<MentorshipGroup> groups;

}
