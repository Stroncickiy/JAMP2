package com.epam.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.spring.dao.CommonDAO;
import com.epam.spring.dao.UserActionDAO;
import com.epam.spring.model.UserAction;
import com.epam.spring.service.UserActionService;

@Service
@Transactional
public class UserActionServiceImpl extends CommonServiceImpl<UserAction> implements UserActionService {
	@Autowired
	private UserActionDAO userActionDAO;

	@Override
	public CommonDAO<UserAction> getDaoDelegate() {
		return userActionDAO;
	}

}
