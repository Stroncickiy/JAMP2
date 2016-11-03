package com.epam.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.dao.MentorshipGroupDAO;
import com.epam.spring.model.MentorshipGroup;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.ParticipantAssignment;
import com.epam.spring.service.MentorshipGroupService;

@Service
@Transactional
public class MentorshipGroupServiceImpl implements MentorshipGroupService {

    @Autowired
    private MentorshipGroupDAO groupDao;

    @Override
    public MentorshipGroup add(MentorshipGroup item) {
        List<ParticipantAssignment> participants = new ArrayList<>();
        participants.add(item.getMentor());
        participants.add(item.getMentee());
        item.setParticipants(participants);
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
        List<ParticipantAssignment> participants = new ArrayList<>();
        participants.add(item.getMentor());
        participants.add(item.getMentee());
        item.setParticipants(participants);
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


}
