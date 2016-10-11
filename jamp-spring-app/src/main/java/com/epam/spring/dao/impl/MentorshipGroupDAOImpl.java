package com.epam.spring.dao.impl;

import com.epam.spring.dao.MentorshipGroupDAO;
import com.epam.spring.model.MentorshipGroup;
import com.epam.spring.model.MentorshipPhase;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

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
}
