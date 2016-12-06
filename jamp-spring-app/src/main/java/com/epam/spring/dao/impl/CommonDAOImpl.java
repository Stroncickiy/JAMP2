package com.epam.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.epam.spring.dao.CommonDAO;

@SuppressWarnings("unchecked")
public abstract class CommonDAOImpl<O> implements CommonDAO<O> {

	private Class<?> targetClass;
	protected EntityManager entityManager;

	public CommonDAOImpl(Class<?> targetClass, EntityManager entityManager) {
		this.targetClass = targetClass;
		this.entityManager = entityManager;

	}

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
		return ((Session) entityManager.getDelegate()).createCriteria(targetClass).list();
	}

	@Override
	public O getById(Long key) {
		return (O) entityManager.find(targetClass, key);
	}

	public void refresh(O item) {
		entityManager.refresh(item);

	}

}
