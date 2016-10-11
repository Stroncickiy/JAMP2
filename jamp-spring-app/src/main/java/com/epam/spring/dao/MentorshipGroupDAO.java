package com.epam.spring.dao;

import com.epam.spring.model.MentorshipGroup;
import com.epam.spring.model.MentorshipPhase;

import java.util.List;

public interface MentorshipGroupDAO extends CommonDAO<MentorshipGroup> {

    List<MentorshipGroup> getForPhase(MentorshipPhase targetMentorshipPhase);
}
