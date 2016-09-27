package com.epam.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.dao.UserDAO;
import com.epam.spring.model.User;
import com.epam.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public User register(User user) {
		return userDAO.add(user);
	}

	public void remove(long id) {
		userDAO.remove(id);
	}

	public User getById(long id) {
		return userDAO.getById(id);
	}

	@Override
	public List<User> getAll() {
		return userDAO.getAll();
	}

	@Override
	public void update(User user) {
		userDAO.update(user);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}

}
