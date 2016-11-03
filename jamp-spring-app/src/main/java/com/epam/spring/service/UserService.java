package com.epam.spring.service;

import java.time.LocalDateTime;
import java.util.List;

import com.epam.spring.model.TimeSpentByUserRecord;
import com.epam.spring.model.User;

public interface UserService extends CommonService<User> {

	User getUserByEmail(String email);

	List<TimeSpentByUserRecord> getStatisticsOfTimeSpentOnSiteForPeriod(LocalDateTime from, LocalDateTime to);
}
