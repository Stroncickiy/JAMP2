package com.epam.spring.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@ToString(of = {"id", "domainArea", "topic"})
@EqualsAndHashCode(of = {"id"})
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

}
