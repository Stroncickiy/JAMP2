package com.epam.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.spring.dao.LectureDAO;
import com.epam.spring.model.Lecture;
import com.epam.spring.model.MentorshipPhase;

@Repository
public class LectureDAOImpl extends CommonDAOImpl<Lecture> implements LectureDAO {

	@Autowired
	public LectureDAOImpl(EntityManager entityManager) {
		super(Lecture.class, entityManager);
	}

	@Override
	public List<Lecture> getForPhase(MentorshipPhase targetMentorshipPhase) {
		Session session = (Session) entityManager.getDelegate();
		Query findPhasesLectures = session.createQuery("from Lecture l where l.phase = :targetPhase");
		findPhasesLectures.setParameter("targetPhase", targetMentorshipPhase);
		return findPhasesLectures.list();
	}

}
