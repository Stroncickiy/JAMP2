package com.epam.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.epam.spring.dao.RequestEntryDAO;
import com.epam.spring.model.RequestEntry;

@Repository
public class RequestEntryDAOImpl extends CommonDAOImpl<RequestEntry> implements RequestEntryDAO {
}
