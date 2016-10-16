package com.epam.spring.dao;

import com.epam.spring.model.MentorshipGroup;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.ParticipantAssignment;

import java.util.List;

public interface MentorshipGroupDAO extends CommonDAO<MentorshipGroup> {

    List<MentorshipGroup> getForPhase(MentorshipPhase targetMentorshipPhase);

    List<ParticipantAssignment> getMentorsWhoMentorsMoreThanTwoMentees();
}
