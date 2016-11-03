package com.epam.spring.service;

import java.util.List;

import com.epam.spring.model.MentorshipGroup;
import com.epam.spring.model.MentorshipPhase;

public interface MentorshipGroupService extends CommonService<MentorshipGroup> {

    List<MentorshipGroup> getForPhase(MentorshipPhase targetMentorshipPhase);


}
