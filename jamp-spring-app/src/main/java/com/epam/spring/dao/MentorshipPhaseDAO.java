package com.epam.spring.dao;

import java.util.Date;
import java.util.List;

import com.epam.spring.dto.CityStatistics;
import com.epam.spring.dto.CompletionStatistics;
import com.epam.spring.model.MentorshipPhase;

public interface MentorshipPhaseDAO extends CommonDAO<MentorshipPhase> {

    List<CityStatistics> getStatisticsForEachCity();

    CompletionStatistics getCompletionStatisticsForPeriod(Date from, Date to);
}
