package com.epam.spring.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.dao.CommonDAO;
import com.epam.spring.dao.LectureDAO;
import com.epam.spring.model.Lecture;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.service.LectureService;

@Service
@Transactional
public class LectureServiceImpl extends CommonServiceImpl<Lecture> implements LectureService {
	@Autowired
	private LectureDAO lectureDao;

	@Override
	public List<Lecture> getForPhase(MentorshipPhase targetMentorshipPhase) {
		return lectureDao.getForPhase(targetMentorshipPhase);
	}

	@Override
	public CommonDAO<Lecture> getDaoDelegate() {
		return lectureDao;
	}

}
