package com.epam.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.epam.spring.dao.UserActionDAO;
import com.epam.spring.model.UserAction;

@Repository
public class UserActionDAOImpl extends CommonDAOImpl<UserAction> implements UserActionDAO {
}
