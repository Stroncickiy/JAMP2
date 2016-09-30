package com.epam.spring.service;

import java.util.List;

import com.epam.spring.model.Lecture;
import com.epam.spring.model.MentorshipPhase;

public interface LectureService extends CommonService<Lecture> {

	List<Lecture> getForPhase(MentorshipPhase targetMentorshipPhase);

}
