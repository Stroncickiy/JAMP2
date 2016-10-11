package com.epam.spring.dao.impl;

import com.epam.spring.dao.ParticipantDAO;
import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.ParticipantAssignment;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class ParticipantDAOImpl extends CommonDAOImpl<ParticipantAssignment>
        implements ParticipantDAO {
    @PostConstruct
    public void init() {
        targetClass = ParticipantAssignment.class;
    }

    @Override
    public List<ParticipantAssignment> getParticipantsOfPhaseByRole(MentorshipPhase phase, ParticipantRole role,
                                                                    ParticipantStatus status) {
        Session session = (Session) entityManager.getDelegate();
        Query findLectorsForPhase = session.createQuery(
                "from ParticipantAssignment pa where pa.phase = :targetPhase and pa.role = :role and pa.status = :status ");
        findLectorsForPhase.setParameter("targetPhase", phase);
        findLectorsForPhase.setParameter("role", role);
        findLectorsForPhase.setParameter("status", status);
        return findLectorsForPhase.list();
    }

    @Override
    public List<ParticipantAssignment> getParticipantsOfPhase(MentorshipPhase phase) {
        Session session = (Session) entityManager.getDelegate();
        Query findLectorsForPhase = session.createQuery(
                "from ParticipantAssignment pa where pa.phase = :targetPhase");
        findLectorsForPhase.setParameter("targetPhase", phase);
        return findLectorsForPhase.list();
    }
}
