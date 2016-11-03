package com.epam.spring.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.dao.MentorshipPhaseDAO;
import com.epam.spring.dto.CityStatistics;
import com.epam.spring.dto.CompletionStatistics;
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
	public boolean remove(MentorshipPhase item) {
		return mentorshipPhaseDAO.remove(item);

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
	public boolean update(MentorshipPhase item) {
		return mentorshipPhaseDAO.update(item);
	}

	@Override
	public void refresh(MentorshipPhase item) {
		mentorshipPhaseDAO.refresh(item);

	}

	@Override
	public List<CityStatistics> getStatisticsForEachCity() {
		return mentorshipPhaseDAO.getStatisticsForEachCity();
	}

	@Override
	public CompletionStatistics getCompletionStatisticsForPeriod(Date from, Date to) {
		return mentorshipPhaseDAO.getCompletionStatisticsForPeriod(from,to);
	}
}
