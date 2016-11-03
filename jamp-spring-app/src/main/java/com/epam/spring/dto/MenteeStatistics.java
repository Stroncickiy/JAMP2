package com.epam.spring.dto;


import com.epam.spring.model.ParticipantAssignment;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenteeStatistics {
    private ParticipantAssignment mentee;
    private int mentorshipWeeks;

}
