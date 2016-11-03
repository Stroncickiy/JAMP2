package com.epam.spring.dao.impl;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import com.epam.spring.dao.UserDAO;
import com.epam.spring.model.TimeSpentByUserRecord;
import com.epam.spring.model.User;

@Repository
public class UserDAOImpl extends CommonDAOImpl<User> implements UserDAO {

	@PostConstruct
	public void init() {
		targetClass = User.class;
	}

	@Override
	@SuppressWarnings("unchecked")
	public User getUserByEmail(String email) {
		Session session = ((Session) entityManager.getDelegate());
		Query findByEmailQuery = session.createQuery("from User u  where u.email = :email ");
		findByEmailQuery.setParameter("email", email);
		Iterator<User> iterate = findByEmailQuery.iterate();
		if (iterate.hasNext()) {
			return iterate.next();
		} else {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TimeSpentByUserRecord> getStatisticsOfTimeSpentOnSiteForPeriod(LocalDateTime from, LocalDateTime to) {
		Session session = ((Session) entityManager.getDelegate());
		SQLQuery sqlQuery = session.createSQLQuery(
				" SELECT email, SUM(duration) as timeSpent FROM (SELECT  email, TIMESTAMPDIFF(SECOND, min(timestamp), max(timestamp)) AS duration FROM mentorship.user_action where timestamp between :from and :to  group by session) AS T group by email ;");
		sqlQuery.setDate("from", Date.from(from.toInstant(ZoneOffset.UTC))).setDate("to",
				Date.from(to.toInstant(ZoneOffset.UTC)));
		sqlQuery.addScalar("email",StringType.INSTANCE).addScalar("timeSpent",LongType.INSTANCE);
		sqlQuery.setResultTransformer(Transformers.aliasToBean(TimeSpentByUserRecord.class));
		return sqlQuery.list();
	}
}
