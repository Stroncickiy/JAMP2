package com.epam.spring.service;

import java.util.List;

public interface CommonService<O> {
	void refresh(O item);

	O add(O item);

	boolean remove(O item);

	O getById(Long id);

	List<O> getAll();

	boolean update(O item);
}
