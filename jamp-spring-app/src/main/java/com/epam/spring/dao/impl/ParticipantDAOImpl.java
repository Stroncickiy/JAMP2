package com.epam.spring.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.spring.dao.ParticipantDAO;
import com.epam.spring.dto.MenteeStatistics;
import com.epam.spring.enums.GroupStatus;
import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;
import com.epam.spring.model.MentorshipGroup;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.MentorshipPhase_;
import com.epam.spring.model.ParticipantAssignment;
import com.epam.spring.model.ParticipantAssignment_;

@Repository
public class ParticipantDAOImpl extends CommonDAOImpl<ParticipantAssignment>
        implements ParticipantDAO {
    private static final long WEEK_IN_MILISECONDS = 7 * 24 * 60 * 60 * 1000;
    private int ITEMS_PER_PAGE = 10;


    @Autowired
	public ParticipantDAOImpl(EntityManager entityManager) {
		super(ParticipantAssignment.class, entityManager);
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


    @Override
    public List<ParticipantAssignment> getMenteesWithoutMentorsInSpecifiedCity(String location) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParticipantAssignment> query = cb.createQuery(ParticipantAssignment.class);
        Root<ParticipantAssignment> p = query.from(ParticipantAssignment.class);
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

    @Override
    public List<MenteeStatistics> getMenteesStatisticsDescendingWithPagination(int pageNumber) {
        Session session = (Session) entityManager.getDelegate();
        Query findMenteesQuery = session.createQuery("from ParticipantAssignment pa where pa.role = :role");
        findMenteesQuery.setParameter("role", ParticipantRole.MENTEE);
        findMenteesQuery.setFirstResult(pageNumber > 1 ? (ITEMS_PER_PAGE * (pageNumber - 1)) : 0);
        findMenteesQuery.setMaxResults(ITEMS_PER_PAGE);
        List<ParticipantAssignment> mentees = findMenteesQuery.list();
        return buildMenteeStatistics(mentees);
    }

    private List<MenteeStatistics> buildMenteeStatistics(List<ParticipantAssignment> mentees) {
        List<MenteeStatistics> menteeStatisticses = new ArrayList<>();
        for (ParticipantAssignment mentee : mentees) {
            MenteeStatistics menteeStatistics = MenteeStatistics
                    .builder()
                    .mentee(mentee)
                    .mentorshipWeeks(countMentorshipWeeks(mentee.getGroups()))
                    .build();
            menteeStatisticses.add(menteeStatistics);
        }
        return menteeStatisticses;
    }

    private int countMentorshipWeeks(List<MentorshipGroup> groups) {
        int mentorshipWeeks = 0;
        for (MentorshipGroup group : groups) {
            if (group.getStatus().equals(GroupStatus.IN_PROGRESS)) {
                long diff = new Date().getTime() - group.getActualStart().getTime();
                mentorshipWeeks += diff / WEEK_IN_MILISECONDS;
            } else if (group.getStatus().equals(GroupStatus.FINISHED) && group.getActualEnd().before(new Date())) {
                long diff = group.getActualEnd().getTime() - group.getActualEnd().getTime();
                mentorshipWeeks += diff / WEEK_IN_MILISECONDS;
            }
        }
        return mentorshipWeeks;
    }



}
