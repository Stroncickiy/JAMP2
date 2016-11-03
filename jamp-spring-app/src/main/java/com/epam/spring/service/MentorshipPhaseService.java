package com.epam.spring.service;

import java.util.Date;
import java.util.List;

import com.epam.spring.dto.CityStatistics;
import com.epam.spring.dto.CompletionStatistics;
import com.epam.spring.model.MentorshipPhase;

public interface MentorshipPhaseService extends CommonService<MentorshipPhase> {


    List<CityStatistics> getStatisticsForEachCity();

    CompletionStatistics getCompletionStatisticsForPeriod(Date from, Date to);
}
