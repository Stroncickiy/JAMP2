package com.epam.spring.service;

import com.epam.spring.model.User;

import java.util.List;

public interface UserService {

	User register(User user);

	void remove(User user);

	User getById(Long id);

	List<User> getAll();

	void update(User user);

	User getUserByEmail(String email);
}
