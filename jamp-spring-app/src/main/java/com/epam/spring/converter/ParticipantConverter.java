package com.epam.spring.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.epam.spring.model.PhaseParticipantAssignment;
import com.epam.spring.service.MentorshipPhaseParticipantService;

@Component
public class ParticipantConverter implements Converter<String, PhaseParticipantAssignment> {
	@Autowired
	private MentorshipPhaseParticipantService participantService;

	@Override
	public PhaseParticipantAssignment convert(String id) {
		return participantService.getById(Long.valueOf(id));
	}
}
