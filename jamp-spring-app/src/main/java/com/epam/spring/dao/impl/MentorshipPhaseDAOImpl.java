package com.epam.spring.dao.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.epam.spring.dao.MentorshipPhaseDAO;
import com.epam.spring.model.MentorshipPhase;

@Repository
public class MentorshipPhaseDAOImpl extends CommonDAOImpl<MentorshipPhase> implements MentorshipPhaseDAO {
	@PostConstruct
	public void init() {
		targetClass = MentorshipPhase.class;
	}
}
