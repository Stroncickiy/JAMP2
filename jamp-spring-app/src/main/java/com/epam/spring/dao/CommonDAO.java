package com.epam.spring.dao;

import java.util.List;

public interface CommonDAO<O> {

	O add(O item);

	boolean update(O item);

	boolean remove(O item);

	List<O> getAll();

	O getById(Long key);
}
