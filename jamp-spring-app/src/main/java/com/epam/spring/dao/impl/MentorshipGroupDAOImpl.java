package com.epam.spring.dao.impl;

import com.epam.spring.dao.MentorshipGroupDAO;
import com.epam.spring.model.MentorshipGroup;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.ParticipantAssignment;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MentorshipGroupDAOImpl extends CommonDAOImpl<MentorshipGroup> implements MentorshipGroupDAO {
    @PostConstruct
    public void init() {
        targetClass = MentorshipGroup.class;
    }

    @Override
    public List<MentorshipGroup> getForPhase(MentorshipPhase targetMentorshipPhase) {
        Session session = (Session) entityManager.getDelegate();
        Query findGroupByPhase = session.createQuery("from MentorshipGroup mg where mg.phase = :targetPhase");
        findGroupByPhase.setParameter("targetPhase", targetMentorshipPhase);
        return findGroupByPhase.list();
    }

    @Override
    public List<ParticipantAssignment> getMentorsWhoMentorsMoreThanTwoMentees() {
        Session session = (Session) entityManager.getDelegate();
        Query findGroups = session.createQuery(" select  mg.mentor from MentorshipGroup mg where mg.status ='IN_PROGRESS' group by mg.mentor having count(mg.id)>1 ");
        List<ParticipantAssignment> mentors = findGroups.list();
        return mentors;
    }
}
