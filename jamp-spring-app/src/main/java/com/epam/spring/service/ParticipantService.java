package com.epam.spring.service;

import java.util.List;

import com.epam.spring.dto.MenteeStatistics;
import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.ParticipantAssignment;

public interface ParticipantService extends CommonService<ParticipantAssignment> {

    List<ParticipantAssignment> getLectorsForPhase(MentorshipPhase phase);

    List<ParticipantAssignment> getParticipantsForPhase(MentorshipPhase phase);

    List<ParticipantAssignment> getParticipantsForPhaseByRole(MentorshipPhase phase, ParticipantRole role);

    List<ParticipantAssignment> getMenteesWithoutMentorsInSpecifiedCity(String location);

    List<ParticipantAssignment> getMentorsWhoMentorsMoreThanTwoMentees();

    List<MenteeStatistics> getMenteesStatisticsDescendingWithPagination(int page);
}
