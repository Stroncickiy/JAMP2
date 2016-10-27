package com.epam.spring.service.impl;

import com.epam.spring.enums.GroupStatus;
import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;
import com.epam.spring.enums.UserRole;
import com.epam.spring.model.*;
import com.epam.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    private MentorshipGroupService mentorshipGroupService;
    @Autowired
    private UserService userSerivice;
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private LectureService lectureService;


    @PostConstruct
    public void init() {


        // Phases

        MentorshipPhase javaMentorshipPhase = new MentorshipPhase();
        javaMentorshipPhase.setLocation("Lviv");
        javaMentorshipPhase.setTitle("Java Mentorship Program");
        javaMentorshipPhase.setStartDate(Date.from(LocalDate.of(2016, 8, 31).atStartOfDay().toInstant(ZoneOffset.UTC)));
        javaMentorshipPhase.setEndDate(Date.from(LocalDate.of(2016, 10, 29).atStartOfDay().toInstant(ZoneOffset.UTC)));
        javaMentorshipPhase = mentorshipPhaseService.add(javaMentorshipPhase);

        MentorshipPhase dotNetMentorshipPhase = new MentorshipPhase();
        dotNetMentorshipPhase.setLocation("Lviv");
        dotNetMentorshipPhase.setTitle(".NEt Mentorship Program");
        dotNetMentorshipPhase.setStartDate(Date.from(LocalDate.of(2016, 8, 31).atStartOfDay().toInstant(ZoneOffset.UTC)));
        dotNetMentorshipPhase.setEndDate(Date.from(LocalDate.of(2016, 10, 29).atStartOfDay().toInstant(ZoneOffset.UTC)));
        dotNetMentorshipPhase = mentorshipPhaseService.add(dotNetMentorshipPhase);


        MentorshipPhase qaMentorshipPhase = new MentorshipPhase();
        qaMentorshipPhase.setLocation("Lviv");
        qaMentorshipPhase.setTitle("QA Mentorship Program");
        qaMentorshipPhase.setStartDate(Date.from(LocalDate.of(2016, 10, 15).atStartOfDay().toInstant(ZoneOffset.UTC)));
        qaMentorshipPhase.setEndDate(Date.from(LocalDate.of(2016, 12, 15).atStartOfDay().toInstant(ZoneOffset.UTC)));
        qaMentorshipPhase = mentorshipPhaseService.add(qaMentorshipPhase);

        MentorshipPhase pythonMentorshipPhase = new MentorshipPhase();
        pythonMentorshipPhase.setLocation("Kharkiv");
        pythonMentorshipPhase.setTitle("Python Mentorship Program");
        pythonMentorshipPhase.setStartDate(Date.from(LocalDate.of(2016, 12, 1).atStartOfDay().toInstant(ZoneOffset.UTC)));
        pythonMentorshipPhase.setEndDate(Date.from(LocalDate.of(2017, 04, 15).atStartOfDay().toInstant(ZoneOffset.UTC)));
        pythonMentorshipPhase = mentorshipPhaseService.add(pythonMentorshipPhase);

        MentorshipPhase phpMentorshipPhase = new MentorshipPhase();
        phpMentorshipPhase.setLocation("Kyiv");
        phpMentorshipPhase.setTitle("PHP Program");
        phpMentorshipPhase.setStartDate(Date.from(LocalDate.of(2016, 7, 10).atStartOfDay().toInstant(ZoneOffset.UTC)));
        phpMentorshipPhase.setEndDate(Date.from(LocalDate.of(2016, 12, 20).atStartOfDay().toInstant(ZoneOffset.UTC)));
        phpMentorshipPhase = mentorshipPhaseService.add(phpMentorshipPhase);


        // Users

        User admin = new User();
        admin.setFirstName("Admin");
        admin.setLastName("Admin");
        admin.setEmail("admin@epam.com");
        admin.setEnabled(true);
        admin.setPassword("adminadmin");
        admin.setPrimarySkill("Admin");
        admin.setLevel(5);
        admin.setBirthDate(Date.from(LocalDate.of(1996, 10, 10).atStartOfDay().toInstant(ZoneOffset.UTC)));
        ArrayList<UserRole> roles = new ArrayList<>();
        roles.add(UserRole.ADMIN);
        roles.add(UserRole.CLIENT);
        admin.setRoles(roles);
        admin = userSerivice.add(admin);


        User clientAlex = new User();
        clientAlex.setFirstName("Alex");
        clientAlex.setLastName("Shamanov");
        clientAlex.setEmail("alex@epam.com");
        clientAlex.setEnabled(true);
        clientAlex.setPrimarySkill("Java");
        clientAlex.setLevel(1);
        clientAlex.setPassword("client");
        clientAlex.setBirthDate(Date.from(LocalDate.of(1994, 2, 12).atStartOfDay().toInstant(ZoneOffset.UTC)));
        ArrayList<UserRole> rolesOfAlex = new ArrayList<>();
        rolesOfAlex.add(UserRole.CLIENT);
        clientAlex.setRoles(rolesOfAlex);
        clientAlex = userSerivice.add(clientAlex);

        User clientVasya = new User();
        clientVasya.setFirstName("Vasya");
        clientVasya.setLastName("Pupkin");
        clientVasya.setEmail("vasya@epam.com");
        clientVasya.setEnabled(true);
        clientVasya.setPassword("client");
        clientVasya.setPrimarySkill("Java");
        clientVasya.setLevel(3);
        clientVasya.setBirthDate(Date.from(LocalDate.of(1993, 9, 12).atStartOfDay().toInstant(ZoneOffset.UTC)));
        ArrayList<UserRole> rolesOfVasya = new ArrayList<>();
        rolesOfVasya.add(UserRole.CLIENT);
        clientVasya.setRoles(rolesOfVasya);
        clientVasya = userSerivice.add(clientVasya);


        ParticipantAssignment javaLector = new ParticipantAssignment();
        javaLector.setAssignee(clientVasya);
        javaLector.setPhase(javaMentorshipPhase);
        javaLector.setRole(ParticipantRole.LECTOR);
        javaLector.setStatus(ParticipantStatus.IN_PROGRESS);
        javaLector = participantService.add(javaLector);


        Lecture javaLecture1 = new Lecture();
        javaLecture1.setDomainArea("Java Core");
        javaLecture1.setTopic("Java Generics");
        javaLecture1.setPhase(javaMentorshipPhase);
        javaLecture1.setLector(javaLector);
        javaLecture1.setStartTime(Date.from(LocalDate.of(2016, 8, 10).atTime(10, 20).toInstant(ZoneOffset.UTC)));
        javaLecture1.setEndTime(Date.from(LocalDate.of(2016, 8, 10).atTime(11, 20).toInstant(ZoneOffset.UTC)));

        Lecture javaLecture2 = new Lecture();
        javaLecture2.setDomainArea("Java Reflection");
        javaLecture2.setTopic("Java Generics");
        javaLecture2.setPhase(javaMentorshipPhase);
        javaLecture2.setLector(javaLector);
        javaLecture2.setStartTime(Date.from(LocalDate.of(2016, 8, 10).atTime(10, 20).toInstant(ZoneOffset.UTC)));
        javaLecture2.setEndTime(Date.from(LocalDate.of(2016, 8, 10).atTime(11, 20).toInstant(ZoneOffset.UTC)));


        lectureService.add(javaLecture1);
        lectureService.add(javaLecture2);


        User clientSlava = new User();
        clientSlava.setFirstName("Slava");
        clientSlava.setLastName("Bobkin");
        clientSlava.setEmail("slava@epam.com");
        clientSlava.setEnabled(true);
        clientSlava.setPassword("client");
        clientSlava.setPrimarySkill("Java");
        clientSlava.setLevel(1);
        clientSlava.setBirthDate(Date.from(LocalDate.of(1995, 2, 10).atStartOfDay().toInstant(ZoneOffset.UTC)));
        ArrayList<UserRole> rolesOfSlava = new ArrayList<>();
        rolesOfSlava.add(UserRole.CLIENT);
        clientSlava.setRoles(rolesOfSlava);
        clientSlava = userSerivice.add(clientSlava);

        ParticipantAssignment javaMentorVasya = new ParticipantAssignment();
        javaMentorVasya.setAssignee(clientVasya);
        javaMentorVasya.setPhase(javaMentorshipPhase);
        javaMentorVasya.setRole(ParticipantRole.MENTOR);
        javaMentorVasya.setStatus(ParticipantStatus.IN_PROGRESS);
        javaMentorVasya = participantService.add(javaMentorVasya);

        ParticipantAssignment javaMenteeSlava = new ParticipantAssignment();
        javaMenteeSlava.setAssignee(clientSlava);
        javaMenteeSlava.setPhase(javaMentorshipPhase);
        javaMenteeSlava.setRole(ParticipantRole.MENTEE);
        javaMenteeSlava.setStatus(ParticipantStatus.IN_PROGRESS);
        javaMenteeSlava = participantService.add(javaMenteeSlava);


        ParticipantAssignment javaMenteeAlex = new ParticipantAssignment();
        javaMenteeAlex.setAssignee(clientAlex);
        javaMenteeAlex.setPhase(javaMentorshipPhase);
        javaMenteeAlex.setRole(ParticipantRole.MENTEE);
        javaMenteeAlex.setStatus(ParticipantStatus.IN_PROGRESS);
        javaMenteeAlex = participantService.add(javaMenteeAlex);

        MentorshipGroup javaMentorshipGroup = new MentorshipGroup();
        javaMentorshipGroup.setPlannedStart(Date.from(LocalDate.of(2016, 9, 1).atStartOfDay().toInstant(ZoneOffset.UTC)));
        javaMentorshipGroup.setActualStart(Date.from(LocalDate.of(2016, 9, 1).atStartOfDay().toInstant(ZoneOffset.UTC)));
        javaMentorshipGroup.setPlannedEnd(Date.from(LocalDate.of(2016, 12, 1).atStartOfDay().toInstant(ZoneOffset.UTC)));
        javaMentorshipGroup.setMentee(javaMenteeSlava);
        javaMentorshipGroup.setMentor(javaMentorVasya);
        javaMentorshipGroup.setPhase(javaMentorshipPhase);
        javaMentorshipGroup.setStatus(GroupStatus.IN_PROGRESS);

        javaMentorshipGroup = mentorshipGroupService.add(javaMentorshipGroup);


        MentorshipGroup javaMentorshipGroup2 = new MentorshipGroup();
        javaMentorshipGroup2.setPlannedStart(Date.from(LocalDate.of(2016, 9, 1).atStartOfDay().toInstant(ZoneOffset.UTC)));
        javaMentorshipGroup2.setActualStart(Date.from(LocalDate.of(2016, 9, 1).atStartOfDay().toInstant(ZoneOffset.UTC)));
        javaMentorshipGroup2.setPlannedEnd(Date.from(LocalDate.of(2016, 12, 1).atStartOfDay().toInstant(ZoneOffset.UTC)));
        javaMentorshipGroup2.setMentee(javaMenteeAlex);
        javaMentorshipGroup2.setMentor(javaMentorVasya);
        javaMentorshipGroup2.setPhase(javaMentorshipPhase);
        javaMentorshipGroup2.setStatus(GroupStatus.IN_PROGRESS);

        javaMentorshipGroup2 = mentorshipGroupService.add(javaMentorshipGroup2);


        User clientMax = new User();
        clientMax.setFirstName("Maxim");
        clientMax.setLastName("Markov");
        clientMax.setEmail("max@epam.com");
        clientMax.setEnabled(true);
        clientMax.setPrimarySkill(".Net");
        clientMax.setLevel(3);
        clientMax.setPassword("client");
        clientMax.setBirthDate(Date.from(LocalDate.of(1992, 1, 11).atStartOfDay().toInstant(ZoneOffset.UTC)));
        ArrayList<UserRole> rolesOfMax = new ArrayList<>();
        rolesOfMax.add(UserRole.CLIENT);
        clientMax.setRoles(rolesOfMax);
        clientMax = userSerivice.add(clientMax);

        User clientAnton = new User();
        clientAnton.setFirstName("Anton");
        clientAnton.setLastName("Baton");
        clientAnton.setEmail("anton@epam.com");
        clientAnton.setEnabled(true);
        clientAnton.setPrimarySkill(".Net");
        clientAnton.setLevel(1);
        clientAnton.setPassword("client");
        clientAnton.setBirthDate(Date.from(LocalDate.of(1990, 3, 12).atStartOfDay().toInstant(ZoneOffset.UTC)));
        ArrayList<UserRole> rolesOfAnton = new ArrayList<>();
        rolesOfAnton.add(UserRole.CLIENT);
        clientAnton.setRoles(rolesOfAnton);
        clientAnton = userSerivice.add(clientAnton);


        ParticipantAssignment dotNetLector = new ParticipantAssignment();
        dotNetLector.setAssignee(clientMax);
        dotNetLector.setPhase(dotNetMentorshipPhase);
        dotNetLector.setRole(ParticipantRole.LECTOR);
        dotNetLector.setStatus(ParticipantStatus.IN_PROGRESS);
        dotNetLector = participantService.add(dotNetLector);


        Lecture dotNetLecture1 = new Lecture();
        dotNetLecture1.setDomainArea(".Net dependency tools");
        dotNetLecture1.setTopic("Nuget");
        dotNetLecture1.setPhase(dotNetMentorshipPhase);
        dotNetLecture1.setLector(javaLector);
        dotNetLecture1.setStartTime(Date.from(LocalDate.of(2016, 8, 10).atTime(10, 20).toInstant(ZoneOffset.UTC)));
        dotNetLecture1.setEndTime(Date.from(LocalDate.of(2016, 8, 10).atTime(11, 20).toInstant(ZoneOffset.UTC)));

        Lecture dotNetLecture2 = new Lecture();
        dotNetLecture2.setDomainArea(".Net advanced");
        dotNetLecture2.setTopic("Advanced debugging");
        dotNetLecture2.setPhase(dotNetMentorshipPhase);
        dotNetLecture2.setLector(dotNetLector);
        dotNetLecture2.setStartTime(Date.from(LocalDate.of(2016, 8, 10).atTime(10, 20).toInstant(ZoneOffset.UTC)));
        dotNetLecture2.setEndTime(Date.from(LocalDate.of(2016, 8, 10).atTime(11, 20).toInstant(ZoneOffset.UTC)));


        lectureService.add(dotNetLecture1);
        lectureService.add(dotNetLecture2);


        ParticipantAssignment dotNetMentorMax = new ParticipantAssignment();
        dotNetMentorMax.setAssignee(clientMax);
        dotNetMentorMax.setPhase(dotNetMentorshipPhase);
        dotNetMentorMax.setRole(ParticipantRole.MENTOR);
        dotNetMentorMax.setStatus(ParticipantStatus.IN_PROGRESS);
        dotNetMentorMax = participantService.add(dotNetMentorMax);

        ParticipantAssignment dotNetMenteeAnton = new ParticipantAssignment();
        dotNetMenteeAnton.setAssignee(clientAnton);
        dotNetMenteeAnton.setPhase(dotNetMentorshipPhase);
        dotNetMenteeAnton.setRole(ParticipantRole.MENTEE);
        dotNetMenteeAnton.setStatus(ParticipantStatus.IN_PROGRESS);
        dotNetMenteeAnton = participantService.add(dotNetMenteeAnton);

        MentorshipGroup dotNetMentorshipGroup = new MentorshipGroup();
        dotNetMentorshipGroup.setPlannedStart(Date.from(LocalDate.of(2016, 9, 1).atStartOfDay().toInstant(ZoneOffset.UTC)));
        dotNetMentorshipGroup.setActualStart(Date.from(LocalDate.of(2016, 9, 1).atStartOfDay().toInstant(ZoneOffset.UTC)));
        dotNetMentorshipGroup.setActualEnd(Date.from(LocalDate.of(2016, 12, 1).atStartOfDay().toInstant(ZoneOffset.UTC)));
        dotNetMentorshipGroup.setPlannedEnd(Date.from(LocalDate.of(2016, 12, 1).atStartOfDay().toInstant(ZoneOffset.UTC)));
        dotNetMentorshipGroup.setMentee(dotNetMenteeAnton);
        dotNetMentorshipGroup.setMentor(dotNetMentorMax);
        dotNetMentorshipGroup.setPhase(dotNetMentorshipPhase);
        dotNetMentorshipGroup.setStatus(GroupStatus.FINISHED);

        dotNetMentorshipGroup = mentorshipGroupService.add(dotNetMentorshipGroup);


        User clientOleg = new User();
        clientOleg.setFirstName("Oleg");
        clientOleg.setLastName("Soda");
        clientOleg.setEmail("oleg@epam.com");
        clientOleg.setEnabled(true);
        clientOleg.setPrimarySkill("PHP");
        clientOleg.setLevel(3);
        clientOleg.setPassword("client");
        clientOleg.setBirthDate(Date.from(LocalDate.of(1993, 5, 13).atStartOfDay().toInstant(ZoneOffset.UTC)));
        ArrayList<UserRole> rolesOfOleg = new ArrayList<>();
        rolesOfOleg.add(UserRole.CLIENT);
        clientOleg.setRoles(rolesOfOleg);
        clientOleg = userSerivice.add(clientOleg);


        ParticipantAssignment phpLector = new ParticipantAssignment();
        phpLector.setAssignee(clientOleg);
        phpLector.setPhase(phpMentorshipPhase);
        phpLector.setRole(ParticipantRole.LECTOR);
        phpLector.setStatus(ParticipantStatus.IN_PROGRESS);
        phpLector = participantService.add(phpLector);

        User clientMarina = new User();
        clientMarina.setFirstName("Marina");
        clientMarina.setLastName("Zotova");
        clientMarina.setEmail("marina@epam.com");
        clientMarina.setEnabled(true);
        clientMarina.setPrimarySkill("QA");
        clientMarina.setLevel(1);
        clientMarina.setPassword("client");
        clientMarina.setBirthDate(Date.from(LocalDate.of(1995, 6, 7).atStartOfDay().toInstant(ZoneOffset.UTC)));
        ArrayList<UserRole> rolesOfMarina = new ArrayList<>();
        rolesOfMarina.add(UserRole.CLIENT);
        clientMarina.setRoles(rolesOfMarina);
        clientMarina = userSerivice.add(clientMarina);
    }

}
