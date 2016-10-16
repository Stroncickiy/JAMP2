package com.epam.spring.service;

import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.ParticipantAssignment;

import java.util.List;

public interface ParticipantService extends CommonService<ParticipantAssignment> {

	List<ParticipantAssignment> getLectorsForPhase(MentorshipPhase phase);

    List<ParticipantAssignment> getParticipantsForPhase(MentorshipPhase phase);

    List<ParticipantAssignment>  getParticipantsForPhaseByRole(MentorshipPhase phase,ParticipantRole role);


}
