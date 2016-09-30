package com.epam.spring.service;

import java.util.List;

public interface CommonService<O> {
	O add(O O);

	void remove(O item);

	O getById(Long id);

	List<O> getAll();

	void update(O item);
}
