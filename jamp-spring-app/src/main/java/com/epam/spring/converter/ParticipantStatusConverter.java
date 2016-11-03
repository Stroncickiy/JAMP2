package com.epam.spring.converter;


import org.springframework.core.convert.converter.Converter;

import com.epam.spring.enums.ParticipantStatus;

public class ParticipantStatusConverter implements Converter<String, ParticipantStatus> {
    @Override
    public ParticipantStatus convert(String s) {
        return ParticipantStatus.valueOf(s);

    }
}
