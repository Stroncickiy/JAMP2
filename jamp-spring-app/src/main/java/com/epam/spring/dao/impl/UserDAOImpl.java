package com.epam.spring.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.spring.dao.UserDAO;
import com.epam.spring.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Override
	public User add(User user) {

		return user;
	}

	@Override
	public void update(User user) {

	}

	@Override
	public void remove(Long id) {

	}

	@Override
	public List<User> getAll() {
		return null;

	}

	@Override
	public User getById(Long id) {
		return null;

	}

	public void processNonProcessedUsers() {

	}

	public void removeAllProcessed() {

	}

	@Override
	public User getUserByEmail(String email) {
		return null;

	}
}
