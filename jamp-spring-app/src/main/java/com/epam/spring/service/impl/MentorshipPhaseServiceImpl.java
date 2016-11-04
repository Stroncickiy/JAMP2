package com.epam.spring.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.dao.CommonDAO;
import com.epam.spring.dao.MentorshipPhaseDAO;
import com.epam.spring.dto.CityStatistics;
import com.epam.spring.dto.CompletionStatistics;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.service.MentorshipPhaseService;

@Service
@Transactional
public class MentorshipPhaseServiceImpl extends CommonServiceImpl<MentorshipPhase> implements MentorshipPhaseService {
	@Autowired
	private MentorshipPhaseDAO mentorshipPhaseDAO;

	@Override
	public List<CityStatistics> getStatisticsForEachCity() {
		return mentorshipPhaseDAO.getStatisticsForEachCity();
	}

	@Override
	public CompletionStatistics getCompletionStatisticsForPeriod(Date from, Date to) {
		return mentorshipPhaseDAO.getCompletionStatisticsForPeriod(from, to);
	}

	@Override
	public CommonDAO<MentorshipPhase> getDaoDelegate() {
		return mentorshipPhaseDAO;
	}
}
