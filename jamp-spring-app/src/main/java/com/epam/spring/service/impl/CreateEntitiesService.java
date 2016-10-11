package com.epam.spring.service.impl;

import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;
import com.epam.spring.enums.UserRole;
import com.epam.spring.model.Lecture;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.ParticipantAssignment;
import com.epam.spring.model.User;
import com.epam.spring.service.LectureService;
import com.epam.spring.service.MentorshipPhaseService;
import com.epam.spring.service.ParticipantService;
import com.epam.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

@Service
public class CreateEntitiesService {
	@Autowired
	private MentorshipPhaseService mentorshipPhaseService;
	@Autowired
	private UserService userSerivice;
	@Autowired
	private ParticipantService participantService;
	@Autowired
	private LectureService lectureService;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();;

	@PostConstruct
	public void init() {
		// Users

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
		admin = userSerivice.add(admin);

		User clientVasya = new User();
		clientVasya.setFirstName("Vasya");
		clientVasya.setLastName("Pupkin");
		clientVasya.setEmail("vasya@epam.com");
		clientVasya.setEnabled(true);
		clientVasya.setPassword(passwordEncoder.encode("client"));
		clientVasya.setPrimarySkill("Java");
		clientVasya.setLevel(3);
		clientVasya.setBirthDate(Date.from(LocalDate.of(1993, 9, 12).atStartOfDay().toInstant(ZoneOffset.UTC)));
		ArrayList<UserRole> rolesOfVasya = new ArrayList<>();
		rolesOfVasya.add(UserRole.CLIENT);
		clientVasya.setRoles(rolesOfVasya);
		clientVasya = userSerivice.add(clientVasya);

		User clientMax = new User();
		clientMax.setFirstName("Maxin");
		clientMax.setLastName("Markov");
		clientMax.setEmail("max@epam.com");
		clientMax.setEnabled(true);
		clientMax.setPrimarySkill(".Net");
		clientMax.setLevel(2);
		clientMax.setPassword(passwordEncoder.encode("client"));
		clientMax.setBirthDate(Date.from(LocalDate.of(1992, 1, 11).atStartOfDay().toInstant(ZoneOffset.UTC)));
		ArrayList<UserRole> rolesOfMax = new ArrayList<>();
		rolesOfMax.add(UserRole.CLIENT);
		clientMax.setRoles(rolesOfMax);
		clientMax = userSerivice.add(clientMax);

		// Phases

		MentorshipPhase javaMentorshipPhase = new MentorshipPhase();
		javaMentorshipPhase.setLocation("Lviv");
		javaMentorshipPhase.setTitle("Java Mentorship Program");
		javaMentorshipPhase.setStartDate(Date.from(LocalDate.of(2016, 8, 31).atStartOfDay().toInstant(ZoneOffset.UTC)));
		javaMentorshipPhase.setEndDate(Date.from(LocalDate.of(2016, 10, 29).atStartOfDay().toInstant(ZoneOffset.UTC)));
		javaMentorshipPhase = mentorshipPhaseService.add(javaMentorshipPhase);

		MentorshipPhase phpMentorshipPhase = new MentorshipPhase();
		phpMentorshipPhase.setLocation("Lviv");
		phpMentorshipPhase.setTitle("PHP Program");
		phpMentorshipPhase.setStartDate(Date.from(LocalDate.of(2016, 7, 10).atStartOfDay().toInstant(ZoneOffset.UTC)));
		phpMentorshipPhase.setEndDate(Date.from(LocalDate.of(2016, 12, 20).atStartOfDay().toInstant(ZoneOffset.UTC)));
		phpMentorshipPhase = mentorshipPhaseService.add(phpMentorshipPhase);

		// Participants
		ParticipantAssignment javaLector = new ParticipantAssignment();
		javaLector.setAssignee(clientVasya);
		javaLector.setPhase(javaMentorshipPhase);
		javaLector.setRole(ParticipantRole.LECTOR);
		javaLector.setStatus(ParticipantStatus.IN_PROGRESS);
		javaLector = participantService.add(javaLector);

		Lecture lecture = new Lecture();
		lecture.setDomainArea("Java Core");
		lecture.setTopic("Java Generics");
		lecture.setPhase(javaMentorshipPhase);
		lecture.setLector(javaLector);
		lecture.setStartTime(Date.from(LocalDate.of(2016, 8, 10).atTime(10, 20).toInstant(ZoneOffset.UTC)));
		lecture.setEndTime(Date.from(LocalDate.of(2016, 8, 10).atTime(11, 20).toInstant(ZoneOffset.UTC)));

		lectureService.add(lecture);

	}

}
