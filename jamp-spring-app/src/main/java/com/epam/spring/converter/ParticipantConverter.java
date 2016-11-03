package com.epam.spring.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.epam.spring.model.ParticipantAssignment;
import com.epam.spring.service.ParticipantService;

@Component
public class ParticipantConverter implements Converter<String, ParticipantAssignment> {
    @Autowired
    private ParticipantService participantService;

    @Override
    public ParticipantAssignment convert(String id) {
        return participantService.getById(Long.valueOf(id));
    }
}
