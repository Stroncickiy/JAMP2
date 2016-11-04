package com.epam.spring.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.spring.dao.UserActionDAO;
import com.epam.spring.model.UserAction;

@Repository
public class UserActionDAOImpl extends CommonDAOImpl<UserAction> implements UserActionDAO {

	@Autowired
	public UserActionDAOImpl(EntityManager entityManager) {
		super(UserAction.class, entityManager);
	}

}
