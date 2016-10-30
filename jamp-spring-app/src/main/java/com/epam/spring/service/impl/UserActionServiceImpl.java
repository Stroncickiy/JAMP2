package com.epam.spring.service.impl;


import com.epam.spring.dao.UserActionDAO;
import com.epam.spring.model.UserAction;
import com.epam.spring.service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActionServiceImpl implements UserActionService {
    @Autowired
    private UserActionDAO userActionDAO;

    @Override
    public void refresh(UserAction item) {
        userActionDAO.refresh(item);
    }

    @Override
    public UserAction add(UserAction item) {
        return userActionDAO.add(item);
    }

    @Override
    public boolean remove(UserAction item) {
        return userActionDAO.remove(item);
    }

    @Override
    public UserAction getById(Long id) {
        return userActionDAO.getById(id);
    }

    @Override
    public List<UserAction> getAll() {
        return userActionDAO.getAll();
    }

    @Override
    public boolean update(UserAction item) {
        return userActionDAO.update(item);
    }
}
