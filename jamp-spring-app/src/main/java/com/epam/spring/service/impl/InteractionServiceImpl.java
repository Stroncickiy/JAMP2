package com.epam.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.dao.CommonDAO;
import com.epam.spring.dao.InteractionEntryDAO;
import com.epam.spring.model.InteractionEntry;
import com.epam.spring.service.InteractionEntryService;

@Service
public class InteractionServiceImpl extends CommonServiceImpl<InteractionEntry> implements InteractionEntryService {
	@Autowired
	private InteractionEntryDAO interationEntryDao;

	@Override
	public CommonDAO<InteractionEntry> getDaoDelegate() {
		return interationEntryDao;
	}

}
