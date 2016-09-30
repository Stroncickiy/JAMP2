package com.epam.spring.service;

import java.util.List;

import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.PhaseParticipantAssignment;

public interface MentorshipPhaseParticipantService extends CommonService<PhaseParticipantAssignment> {

	List<PhaseParticipantAssignment> getLectorsForPhase(MentorshipPhase phase);

}
