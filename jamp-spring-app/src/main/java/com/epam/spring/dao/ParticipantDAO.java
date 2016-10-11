package com.epam.spring.dao;

import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.ParticipantAssignment;

import java.util.List;

public interface ParticipantDAO extends CommonDAO<ParticipantAssignment> {

	List<ParticipantAssignment> getParticipantsOfPhaseByRole(MentorshipPhase phase, ParticipantRole role,
                                                             ParticipantStatus status);

	List<ParticipantAssignment> getParticipantsOfPhase(MentorshipPhase phase);
}
