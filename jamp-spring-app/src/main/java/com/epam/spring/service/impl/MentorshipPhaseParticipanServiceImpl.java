package com.epam.spring.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.app.enums.ParticipantRole;
import com.epam.spring.dao.MentorshipPhaseParticipantDAO;
import com.epam.spring.enums.ParticipantStatus;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.PhaseParticipantAssignment;
import com.epam.spring.service.MentorshipPhaseParticipantService;

@Service
@Transactional
public class MentorshipPhaseParticipanServiceImpl implements MentorshipPhaseParticipantService {
	@Autowired
	private MentorshipPhaseParticipantDAO participantDAO;

	@Override
	public PhaseParticipantAssignment add(PhaseParticipantAssignment item) {
		return participantDAO.add(item);
	}

	@Override
	public boolean remove(PhaseParticipantAssignment item) {
		return participantDAO.remove(item);
	}

	@Override
	public PhaseParticipantAssignment getById(Long id) {
		return participantDAO.getById(id);
	}

	@Override
	public List<PhaseParticipantAssignment> getAll() {
		return participantDAO.getAll();
	}

	@Override
	public boolean update(PhaseParticipantAssignment item) {
		return participantDAO.update(item);
	}

	@Override
	public void refresh(PhaseParticipantAssignment item) {
		participantDAO.refresh(item);

	}

	@Override
	public List<PhaseParticipantAssignment> getLectorsForPhase(MentorshipPhase phase) {
		return participantDAO.getParticipantsOfPhaseByRole(phase, ParticipantRole.LECTOR,
				ParticipantStatus.IN_PROGRESS);
	}

}
