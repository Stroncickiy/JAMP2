package com.epam.spring.dao;

import java.util.List;

import com.epam.spring.model.MentorshipGroup;
import com.epam.spring.model.MentorshipPhase;

public interface MentorshipGroupDAO extends CommonDAO<MentorshipGroup> {

    List<MentorshipGroup> getForPhase(MentorshipPhase targetMentorshipPhase);


}
