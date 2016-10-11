package com.epam.spring.dao.impl;

import com.epam.spring.dao.MentorshipPhaseDAO;
import com.epam.spring.model.MentorshipPhase;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class MentorshipPhaseDAOImpl extends CommonDAOImpl<MentorshipPhase> implements MentorshipPhaseDAO {
	@PostConstruct
	public void init() {
		targetClass = MentorshipPhase.class;
	}
}
