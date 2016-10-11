package com.epam.spring.dao.impl;

import com.epam.spring.dao.CommonDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class CommonDAOImpl<O> implements CommonDAO<O> {

	@Autowired
	protected EntityManager entityManager;
	protected Class<?> targetClass;

	@Override
	public O add(O item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public boolean update(O item) {
		try {
			entityManager.merge(item);
			return true;
		} catch (HibernateException e) {
			return false;
		}

	}

	@Override
	public boolean remove(O item) {
		try {
			entityManager.remove(item);
			return true;
		} catch (HibernateException e) {
			return false;
		}

	}

	@Override
	public List<O> getAll() {
		return ((Session) entityManager.getDelegate()).createCriteria(getTargetClass()).list();
	}

	protected Class<?> getTargetClass() {
		return targetClass;
	}

	@Override
	public O getById(Long key) {
		return (O) entityManager.find(getTargetClass(), key);
	}

	public void refresh(O item) {
		entityManager.refresh(item);

	}

}
