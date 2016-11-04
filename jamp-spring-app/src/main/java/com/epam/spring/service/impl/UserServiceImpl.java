package com.epam.spring.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.spring.dao.CommonDAO;
import com.epam.spring.dao.UserDAO;
import com.epam.spring.model.TimeSpentByUserRecord;
import com.epam.spring.model.User;
import com.epam.spring.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends CommonServiceImpl<User> implements UserService {

	@Autowired
	private UserDAO userDAO;

	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void init() {
		passwordEncoder = new BCryptPasswordEncoder();
	}

	public User add(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		return userDAO.add(user);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}

	@Override
	public List<TimeSpentByUserRecord> getStatisticsOfTimeSpentOnSiteForPeriod(LocalDateTime from, LocalDateTime to) {
		return userDAO.getStatisticsOfTimeSpentOnSiteForPeriod(from, to);
	}

	@Override
	public CommonDAO<User> getDaoDelegate() {
		return userDAO;
	}

}
