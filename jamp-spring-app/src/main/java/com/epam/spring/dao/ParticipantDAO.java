package com.epam.spring.dao;

import java.util.List;

import com.epam.spring.dto.MenteeStatistics;
import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.ParticipantAssignment;

public interface ParticipantDAO extends CommonDAO<ParticipantAssignment> {

	List<ParticipantAssignment> getParticipantsOfPhaseByRole(MentorshipPhase phase, ParticipantRole role,
                                                             ParticipantStatus status);

	List<ParticipantAssignment> getParticipantsOfPhase(MentorshipPhase phase);

    List<ParticipantAssignment> getMenteesWithoutMentorsInSpecifiedCity(String location);

    List<ParticipantAssignment> getMentorsWhoMentorsMoreThanTwoMentees();

    List<MenteeStatistics> getMenteesStatisticsDescendingWithPagination(int page);
}
