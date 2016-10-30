package com.epam.spring.dao.impl;

import com.epam.spring.dao.UserActionDAO;
import com.epam.spring.model.UserAction;
import org.springframework.stereotype.Repository;

@Repository
public class UserActionDAOImpl extends CommonDAOImpl<UserAction> implements UserActionDAO {
}
