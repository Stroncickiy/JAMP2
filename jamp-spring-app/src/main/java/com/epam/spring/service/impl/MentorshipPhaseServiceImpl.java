package com.epam.spring.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.dao.MentorshipPhaseDAO;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.service.MentorshipPhaseService;

@Service
@Transactional
public class MentorshipPhaseServiceImpl implements MentorshipPhaseService {
	@Autowired
	private MentorshipPhaseDAO mentorshipPhaseDAO;


	@Override
	public MentorshipPhase add(MentorshipPhase O) {
		return mentorshipPhaseDAO.add(O);
	}

	@Override
	public void remove(MentorshipPhase item) {
		mentorshipPhaseDAO.remove(item);

	}

	@Override
	public MentorshipPhase getById(Long id) {
		return mentorshipPhaseDAO.getById(id);
	}

	@Override
	public List<MentorshipPhase> getAll() {
		return mentorshipPhaseDAO.getAll();
	}

	@Override
	public void update(MentorshipPhase item) {
		mentorshipPhaseDAO.update(item);
	}

}
