package com.epam.spring.service;

import com.epam.spring.model.Lecture;
import com.epam.spring.model.MentorshipPhase;

import java.util.List;

public interface LectureService extends CommonService<Lecture> {

	List<Lecture> getForPhase(MentorshipPhase targetMentorshipPhase);

}
