package com.epam.spring.service.impl;

import com.epam.spring.dao.RequestEntryDAO;
import com.epam.spring.model.RequestEntry;
import com.epam.spring.service.RequestEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RequestEntryServiceImpl implements RequestEntryService {
    @Autowired
    private RequestEntryDAO requestEntryDAO;

    @Override
    public void refresh(RequestEntry item) {
        requestEntryDAO.refresh(item);
    }

    @Override
    public RequestEntry add(RequestEntry item) {
        return requestEntryDAO.add(item);
    }

    @Override
    public boolean remove(RequestEntry item) {
        return requestEntryDAO.remove(item);
    }

    @Override
    public RequestEntry getById(Long id) {
        return requestEntryDAO.getById(id);
    }

    @Override
    public List<RequestEntry> getAll() {
        return requestEntryDAO.getAll();
    }

    @Override
    public boolean update(RequestEntry item) {
        return requestEntryDAO.update(item);
    }
}
