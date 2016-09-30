package com.epam.spring.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.epam.spring.app.enums.ParticipantRole;
import com.epam.spring.dao.MentorshipPhaseParticipantDAO;
import com.epam.spring.enums.ParticipantStatus;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.PhaseParticipantAssignment;

@Repository
public class MentorshipPhaseParticipantDAOImpl extends CommonDAOImpl<PhaseParticipantAssignment>
		implements MentorshipPhaseParticipantDAO {
	@PostConstruct
	public void init() {
		targetClass = PhaseParticipantAssignment.class;
	}

	@Override
	public List<PhaseParticipantAssignment> getParticipantsOfPhaseByRole(MentorshipPhase phase, ParticipantRole role,
			ParticipantStatus status) {
		Session session = (Session) entityManager.getDelegate();
		Query findLectorsForPhase = session.createQuery(
				"from PhaseParticipantAssignment ppa where ppa.phase = :targetPhase and ppa.role = :role and ppa.status = :status ");
		findLectorsForPhase.setParameter("targetPhase", phase);
		findLectorsForPhase.setParameter("role", role);
		findLectorsForPhase.setParameter("status", status);
		return findLectorsForPhase.list();
	}
}
