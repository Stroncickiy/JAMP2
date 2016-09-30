package com.epam.spring.dao;

import java.util.List;

import com.epam.spring.app.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.PhaseParticipantAssignment;

public interface MentorshipPhaseParticipantDAO extends CommonDAO<PhaseParticipantAssignment> {

	List<PhaseParticipantAssignment> getParticipantsOfPhaseByRole(MentorshipPhase phase, ParticipantRole role,
			ParticipantStatus status);

}
