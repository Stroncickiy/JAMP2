package com.epam.spring.service.impl;

import com.epam.spring.dao.ParticipantDAO;
import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.ParticipantAssignment;
import com.epam.spring.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {
	@Autowired
	private ParticipantDAO participantDAO;

	@Override
	public ParticipantAssignment add(ParticipantAssignment item) {
		return participantDAO.add(item);
	}

	@Override
	public boolean remove(ParticipantAssignment item) {
		return participantDAO.remove(item);
	}

	@Override
	public ParticipantAssignment getById(Long id) {
		return participantDAO.getById(id);
	}

	@Override
	public List<ParticipantAssignment> getAll() {
		return participantDAO.getAll();
	}

	@Override
	public boolean update(ParticipantAssignment item) {
		return participantDAO.update(item);
	}

	@Override
	public void refresh(ParticipantAssignment item) {
		participantDAO.refresh(item);

	}

	@Override
	public List<ParticipantAssignment> getLectorsForPhase(MentorshipPhase phase) {
		return participantDAO.getParticipantsOfPhaseByRole(phase, ParticipantRole.LECTOR,
				ParticipantStatus.IN_PROGRESS);
	}

	@Override
	public List<ParticipantAssignment> getParticipantsForPhase(MentorshipPhase phase) {
		return participantDAO.getParticipantsOfPhase(phase);
	}

	@Override
	public List<ParticipantAssignment> getParticipantsForPhaseByRole(MentorshipPhase phase,ParticipantRole role) {
		 return participantDAO.getParticipantsOfPhaseByRole(phase, role,
				ParticipantStatus.IN_PROGRESS);
	}

}
