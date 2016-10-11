package com.epam.spring.dao.impl;

import com.epam.spring.dao.UserDAO;
import com.epam.spring.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Iterator;

@Repository
public class UserDAOImpl extends CommonDAOImpl<User> implements UserDAO {

	@PostConstruct
	public void init() {
		targetClass = User.class;
	}

	@Override
	public User getUserByEmail(String email) {
		Session session = ((Session) entityManager.getDelegate());
		Query findByEmailQuery = session.createQuery("from User u  where u.email = :email ");
		findByEmailQuery.setParameter("email", email);
		Iterator<User> iterate = findByEmailQuery.iterate();
		if (iterate.hasNext()) {
			return (User) iterate.next();
		} else {
			return null;
		}

	}
}
