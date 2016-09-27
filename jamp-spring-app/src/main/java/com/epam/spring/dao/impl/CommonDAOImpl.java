package com.epam.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.spring.dao.CommonDAO;

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

}
