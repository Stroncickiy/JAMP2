package com.epam.spring.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.dao.CommonDAO;
import com.epam.spring.dao.ParticipantDAO;
import com.epam.spring.dto.MenteeStatistics;
import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.ParticipantAssignment;
import com.epam.spring.service.ParticipantService;

@Service
@Transactional
public class ParticipantServiceImpl extends CommonServiceImpl<ParticipantAssignment> implements ParticipantService {
    @Autowired
    private ParticipantDAO participantDAO;


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
    public List<ParticipantAssignment> getParticipantsForPhaseByRole(MentorshipPhase phase, ParticipantRole role) {
        return participantDAO.getParticipantsOfPhaseByRole(phase, role,
                ParticipantStatus.IN_PROGRESS);
    }

    @Override
    public List<ParticipantAssignment> getMenteesWithoutMentorsInSpecifiedCity(String location) {
        return participantDAO.getMenteesWithoutMentorsInSpecifiedCity(location);
    }

    @Override
    public List<ParticipantAssignment> getMentorsWhoMentorsMoreThanTwoMentees() {
        return participantDAO.getMentorsWhoMentorsMoreThanTwoMentees();
    }

    @Override
    public List<MenteeStatistics> getMenteesStatisticsDescendingWithPagination(int page) {
        return participantDAO.getMenteesStatisticsDescendingWithPagination(page);
    }

	@Override
	public CommonDAO<ParticipantAssignment> getDaoDelegate() {
		return participantDAO;
	}
}
