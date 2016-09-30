package com.epam.spring.service.impl;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.epam.spring.app.enums.UserRole;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.User;
import com.epam.spring.service.MentorshipPhaseService;
import com.epam.spring.service.UserService;

@Service
public class CreateEntitiesService {
	@Autowired
	private MentorshipPhaseService mentorshipPhaseService;
	@Autowired
	private UserService userSerivice;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();;

	@PostConstruct
	public void init() {
		// Users
		{
			User admin = new User();
			admin.setFirstName("Admin");
			admin.setLastName("Admin");
			admin.setEmail("admin@epam.com");
			admin.setEnabled(true);
			admin.setPassword(passwordEncoder.encode("admin"));
			admin.setPrimarySkill("Admin");
			admin.setLevel(5);
			admin.setBirthDate(Date.from(LocalDate.of(1996, 10, 10).atStartOfDay().toInstant(ZoneOffset.UTC)));
			ArrayList<UserRole> roles = new ArrayList<>();
			roles.add(UserRole.ADMIN);
			roles.add(UserRole.CLIENT);
			admin.setRoles(roles);
			userSerivice.add(admin);
		}
		{
			User clientVasya = new User();
			clientVasya.setFirstName("Vasya");
			clientVasya.setLastName("Pupkin");
			clientVasya.setEmail("vasya@epam.com");
			clientVasya.setEnabled(true);
			clientVasya.setPassword(passwordEncoder.encode("client"));
			clientVasya.setPrimarySkill("Java");
			clientVasya.setLevel(3);
			clientVasya.setBirthDate(Date.from(LocalDate.of(1993, 9, 12).atStartOfDay().toInstant(ZoneOffset.UTC)));
			ArrayList<UserRole> roles = new ArrayList<>();
			roles.add(UserRole.CLIENT);
			clientVasya.setRoles(roles);
			userSerivice.add(clientVasya);
		}
		{
			User clientMax = new User();
			clientMax.setFirstName("Maxin");
			clientMax.setLastName("Markov");
			clientMax.setEmail("max@epam.com");
			clientMax.setEnabled(true);
			clientMax.setPrimarySkill(".Net");
			clientMax.setLevel(2);
			clientMax.setPassword(passwordEncoder.encode("client"));
			clientMax.setBirthDate(Date.from(LocalDate.of(1992, 1, 11).atStartOfDay().toInstant(ZoneOffset.UTC)));
			ArrayList<UserRole> roles = new ArrayList<>();
			roles.add(UserRole.CLIENT);
			clientMax.setRoles(roles);
			userSerivice.add(clientMax);
		}
		// Phases
		{
			MentorshipPhase javaMentorshipPhase = new MentorshipPhase();
			javaMentorshipPhase.setLocation("Lviv");
			javaMentorshipPhase.setTitle("Java Mentorship Program");
			javaMentorshipPhase
					.setStartDate(Date.from(LocalDate.of(2016, 8, 31).atStartOfDay().toInstant(ZoneOffset.UTC)));
			javaMentorshipPhase
					.setEndDate(Date.from(LocalDate.of(2016, 10, 29).atStartOfDay().toInstant(ZoneOffset.UTC)));
			mentorshipPhaseService.add(javaMentorshipPhase);
		}
		{
			MentorshipPhase phpMentorshipPhase = new MentorshipPhase();
			phpMentorshipPhase.setLocation("Lviv");
			phpMentorshipPhase.setTitle("PHP Program");
			phpMentorshipPhase
					.setStartDate(Date.from(LocalDate.of(2016, 7, 10).atStartOfDay().toInstant(ZoneOffset.UTC)));
			phpMentorshipPhase
					.setEndDate(Date.from(LocalDate.of(2016, 12, 20).atStartOfDay().toInstant(ZoneOffset.UTC)));
			mentorshipPhaseService.add(phpMentorshipPhase);

		}
	}

}
