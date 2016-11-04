package com.epam.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.spring.dao.MentorshipGroupDAO;
import com.epam.spring.model.MentorshipGroup;
import com.epam.spring.model.MentorshipPhase;

@Repository
public class MentorshipGroupDAOImpl extends CommonDAOImpl<MentorshipGroup> implements MentorshipGroupDAO {

	@Autowired
	public MentorshipGroupDAOImpl(EntityManager entityManager) {
		super(MentorshipGroup.class, entityManager);
	}

	@Override
	public List<MentorshipGroup> getForPhase(MentorshipPhase targetMentorshipPhase) {
		Session session = (Session) entityManager.getDelegate();
		Query findGroupByPhase = session.createQuery("from MentorshipGroup mg where mg.phase = :targetPhase");
		findGroupByPhase.setParameter("targetPhase", targetMentorshipPhase);
		return findGroupByPhase.list();
	}

}
