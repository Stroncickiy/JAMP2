package com.epam.spring.dao.impl;

import com.epam.spring.dao.ParticipantDAO;
import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.MentorshipPhase_;
import com.epam.spring.model.ParticipantAssignment;
import com.epam.spring.model.ParticipantAssignment_;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
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


    // retrieves all participant assignment from phases where location = specified location and no groups with status in progress
    @Override
    public List<ParticipantAssignment> getMenteesWithoutMentorsInSpecifiedCity(String location) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParticipantAssignment> query = cb.createQuery(ParticipantAssignment.class);
        Root p = query.from(ParticipantAssignment.class);
        Join<ParticipantAssignment, MentorshipPhase> assignmentMentorshipPhaseJoin = p.join(ParticipantAssignment_.phase);
        query.where(cb.and(
                cb.equal(p.get(ParticipantAssignment_.role), ParticipantRole.MENTEE),
                cb.equal(assignmentMentorshipPhaseJoin.get(MentorshipPhase_.location), location),
                cb.equal(cb.size(p.get(ParticipantAssignment_.groups)), 0)));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<ParticipantAssignment> getMentorsWhoMentorsMoreThanTwoMentees() {
        Session session = (Session) entityManager.getDelegate();
        Query findMentorsQuery = session.createQuery("  from ParticipantAssignment pa where pa.status = :status and pa.role = :role and size(pa.groups) > 1 ");
        findMentorsQuery.setParameter("status", ParticipantStatus.IN_PROGRESS);
        findMentorsQuery.setParameter("role", ParticipantRole.MENTOR);
        return findMentorsQuery.list();
    }


}
