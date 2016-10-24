package com.epam.spring.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

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
