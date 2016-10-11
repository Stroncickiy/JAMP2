package com.epam.spring.dao;

import com.epam.spring.model.Lecture;
import com.epam.spring.model.MentorshipPhase;

import java.util.List;

public interface LectureDAO extends CommonDAO<Lecture> {

	List<Lecture> getForPhase(MentorshipPhase targetMentorshipPhase);



}
