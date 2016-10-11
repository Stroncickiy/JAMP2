package com.epam.spring.service.impl;

import com.epam.spring.dao.UserDAO;
import com.epam.spring.model.User;
import com.epam.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public User add(User user) {
		return userDAO.add(user);
	}

	public boolean remove(User user) {
		return userDAO.remove(user);
	}

	public User getById(long id) {
		return userDAO.getById(id);
	}

	@Override
	public List<User> getAll() {
		return userDAO.getAll();
	}

	@Override
	public boolean update(User user) {
		return userDAO.update(user);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}

	@Override
	public User getById(Long id) {
		return userDAO.getById(id);
	}

	@Override
	public void refresh(User item) {
		userDAO.refresh(item);

	}

}
