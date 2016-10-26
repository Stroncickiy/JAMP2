package com.epam.spring.dao.impl;

import com.epam.spring.dao.MentorshipPhaseDAO;
import com.epam.spring.dto.CityStatistics;
import com.epam.spring.dto.CompletionStatistics;
import com.epam.spring.model.MentorshipPhase;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Repository
public class MentorshipPhaseDAOImpl extends CommonDAOImpl<MentorshipPhase> implements MentorshipPhaseDAO {
    @PostConstruct
    public void init() {
        targetClass = MentorshipPhase.class;
    }

    @Override
    public List<CityStatistics> getStatisticsForEachCity() {
        // TODO
        return null;
    }

    @Override
    public CompletionStatistics getCompletionStatisticsForPeriod(Date from, Date to) {
        // TODO
        return null;
    }
}
