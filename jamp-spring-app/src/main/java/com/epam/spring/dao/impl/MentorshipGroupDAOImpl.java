package com.epam.spring.dao.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.epam.spring.dao.MentorshipGroupDAO;
import com.epam.spring.model.MentorshipGroup;

@Repository
public class MentorshipGroupDAOImpl extends CommonDAOImpl<MentorshipGroup> implements MentorshipGroupDAO {
	@PostConstruct
	public void init() {
		targetClass = MentorshipGroup.class;
	}
}
