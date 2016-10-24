package com.epam.spring.service;

import com.epam.spring.model.MentorshipGroup;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.ParticipantAssignment;

import java.util.List;

public interface MentorshipGroupService extends CommonService<MentorshipGroup> {

    List<MentorshipGroup> getForPhase(MentorshipPhase targetMentorshipPhase);


}
