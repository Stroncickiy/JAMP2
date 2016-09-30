package com.epam.spring.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.dao.LectureDAO;
import com.epam.spring.model.Lecture;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.service.LectureService;

@Service
@Transactional
public class LectureServiceImpl implements LectureService {
	@Autowired
	private LectureDAO lectureDao;

	@Override
	public Lecture add(Lecture item) {
		return lectureDao.add(item);
	}

	@Override
	public boolean remove(Lecture item) {
		return lectureDao.remove(item);

	}

	@Override
	public Lecture getById(Long key) {
		return lectureDao.getById(key);
	}

	@Override
	public List<Lecture> getAll() {
		return lectureDao.getAll();
	}

	@Override
	public boolean update(Lecture item) {
		return lectureDao.update(item);

	}

	@Override
	public List<Lecture> getForPhase(MentorshipPhase targetMentorshipPhase) {
		return lectureDao.getForPhase(targetMentorshipPhase);
	}

	@Override
	public void refresh(Lecture item) {
		lectureDao.refresh(item);
		
	}

}
