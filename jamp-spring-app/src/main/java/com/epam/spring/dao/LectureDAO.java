package com.epam.spring.dao;

import java.util.List;

import com.epam.spring.model.Lecture;
import com.epam.spring.model.MentorshipPhase;

public interface LectureDAO extends CommonDAO<Lecture> {

	List<Lecture> getForPhase(MentorshipPhase targetMentorshipPhase);



}
