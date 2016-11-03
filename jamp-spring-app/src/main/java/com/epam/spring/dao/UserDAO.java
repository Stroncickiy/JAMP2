package com.epam.spring.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.epam.spring.model.TimeSpentByUserRecord;
import com.epam.spring.model.User;

public interface UserDAO extends CommonDAO<User> {

	User getUserByEmail(String email);

	List<TimeSpentByUserRecord> getStatisticsOfTimeSpentOnSiteForPeriod(LocalDateTime from, LocalDateTime to);

}
