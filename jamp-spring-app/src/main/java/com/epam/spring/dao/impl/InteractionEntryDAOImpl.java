package com.epam.spring.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.spring.dao.InteractionEntryDAO;
import com.epam.spring.model.InteractionEntry;

@Repository
public class InteractionEntryDAOImpl extends CommonDAOImpl<InteractionEntry> implements InteractionEntryDAO {

	@Autowired
	public InteractionEntryDAOImpl(EntityManager entityManager) {
		super(InteractionEntry.class, entityManager);
	}

}
