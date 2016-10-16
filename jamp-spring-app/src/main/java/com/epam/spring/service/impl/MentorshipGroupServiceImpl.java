package com.epam.spring.service.impl;

import com.epam.spring.dao.MentorshipGroupDAO;
import com.epam.spring.model.MentorshipGroup;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.ParticipantAssignment;
import com.epam.spring.service.MentorshipGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MentorshipGroupServiceImpl implements MentorshipGroupService {

	@Autowired
	private MentorshipGroupDAO groupDao;

	@Override
	public MentorshipGroup add(MentorshipGroup item) {
		return groupDao.add(item);
	}

	@Override
	public boolean remove(MentorshipGroup item) {
		return groupDao.remove(item);
	}

	@Override
	public MentorshipGroup getById(Long id) {
		return groupDao.getById(id);
	}

	@Override
	public List<MentorshipGroup> getAll() {
		return groupDao.getAll();
	}

	@Override
	public boolean update(MentorshipGroup item) {
		return groupDao.update(item);
	}

	@Override
	public void refresh(MentorshipGroup item) {
		groupDao.refresh(item);

	}

	@Override
	public List<MentorshipGroup> getForPhase(MentorshipPhase targetMentorshipPhase) {
		return groupDao.getForPhase(targetMentorshipPhase);
	}

	@Override
	public List<ParticipantAssignment> getMentorsWhoMentorsMoreThanTwoMentees() {
		return groupDao.getMentorsWhoMentorsMoreThanTwoMentees();
	}
}
