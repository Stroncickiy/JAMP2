package com.epam.spring.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.spring.dao.MentorshipPhaseDAO;
import com.epam.spring.dto.CityStatistics;
import com.epam.spring.dto.CompletionStatistics;
import com.epam.spring.model.MentorshipPhase;

@Repository
public class MentorshipPhaseDAOImpl extends CommonDAOImpl<MentorshipPhase> implements MentorshipPhaseDAO {
  
	@Autowired
	public MentorshipPhaseDAOImpl(EntityManager entityManager) {
		super(MentorshipPhase.class, entityManager);
	}

    @Override
    public List<CityStatistics> getStatisticsForEachCity() {
        List<CityStatistics> statistics = new ArrayList<>();
        Session session = (Session) entityManager.getDelegate();
        Query findLocations = session.createQuery(
                "select distinct mp.location from MentorshipPhase mp");
        List<String> listLocations = findLocations.list();
        for (String location : listLocations) {
            long countPhases = (long) session.createQuery(" select count(*) from MentorshipPhase mp where mp.location =:location").setParameter("location", location).uniqueResult();
            long countParticipants = (long) session.createQuery(" select count(*) from ParticipantAssignment pa where pa.phase.location =:location").setParameter("location", location).uniqueResult();
            CityStatistics cityStatistics = CityStatistics
                    .builder()
                    .cityName(location)
                    .countOfPhases((int) countPhases)
                    .countOfParticipants((int) countParticipants)
                    .build();
            statistics.add(cityStatistics);
        }

        return statistics;
    }

    @Override
    public CompletionStatistics getCompletionStatisticsForPeriod(Date from, Date to) {
        Session session = (Session) entityManager.getDelegate();
        long countAll = (long) session.createQuery("select  count(*) from MentorshipGroup mg where  mg.actualStart between :DateFrom and :DateTo and mg.actualEnd between  :DateFrom and :DateTo ")
                .setParameter("DateFrom", from)
                .setParameter("DateTo", to)
                .uniqueResult();
        long countSuccess = (long) session.createQuery("select  count(*) from MentorshipGroup mg where  mg.actualStart between :DateFrom and :DateTo and mg.actualEnd between  :DateFrom and :DateTo  and mg.status = 'FINISHED' ")
                .setParameter("DateFrom", from)
                .setParameter("DateTo", to)
                .uniqueResult();
        if (countAll > 0) {
            return CompletionStatistics.builder()
                    .countOfAllMentees(countAll)
                    .countOfSuccessfulGraduations(countSuccess)
                    .successPercentage((Double.valueOf(countSuccess) / Double.valueOf(countAll)) * 100)
                    .build();
        } else {
            return CompletionStatistics.builder()
                    .countOfAllMentees(0L)
                    .countOfSuccessfulGraduations(0L)
                    .successPercentage(0D)
                    .build();
        }
    }

}
