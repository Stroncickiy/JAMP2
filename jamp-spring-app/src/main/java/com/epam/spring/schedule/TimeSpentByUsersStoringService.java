package com.epam.spring.schedule;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.epam.spring.model.TimeSpentByUserRecord;
import com.epam.spring.pdf.SiteUsagePdfCreator;
import com.epam.spring.service.UserService;

@Service
public class TimeSpentByUsersStoringService {
	@Autowired
	private UserService userService;

	@Scheduled(cron = "0 0 12 28 1/1 ?")
	public void saveStatisticsForLastMonth() throws IOException {
		LocalDate today = LocalDate.now();

		LocalDate start = today.with(firstDayOfMonth());
		LocalDate end = today.with(lastDayOfMonth());
		LocalDateTime from = start.atStartOfDay();
		LocalDateTime to = end.atTime(23, 59, 59);

		List<TimeSpentByUserRecord> statisticsOfTimeSpentOnSiteForPeriod = userService
				.getStatisticsOfTimeSpentOnSiteForPeriod(from, to);

		byte[] statisticsInPdf = SiteUsagePdfCreator.createPdf(statisticsOfTimeSpentOnSiteForPeriod);

		File statisticsFile = new File(
				"timeSpentStatistics" + today.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()) + "_"
						+ today.getYear() + ".pdf");

		FileUtils.writeByteArrayToFile(statisticsFile, statisticsInPdf);

	}

}
