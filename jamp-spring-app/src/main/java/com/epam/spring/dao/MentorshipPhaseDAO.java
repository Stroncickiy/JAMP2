package com.epam.spring.dao;

import com.epam.spring.dto.CityStatistics;
import com.epam.spring.dto.CompletionStatistics;
import com.epam.spring.model.MentorshipPhase;

import java.util.Date;
import java.util.List;

public interface MentorshipPhaseDAO extends CommonDAO<MentorshipPhase> {

    List<CityStatistics> getStatisticsForEachCity();

    CompletionStatistics getCompletionStatisticsForPeriod(Date from, Date to);
}
