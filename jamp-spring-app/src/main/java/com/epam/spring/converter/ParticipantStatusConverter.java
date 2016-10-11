package com.epam.spring.converter;


import com.epam.spring.enums.ParticipantStatus;
import org.springframework.core.convert.converter.Converter;

public class ParticipantStatusConverter implements Converter<String, ParticipantStatus> {
    @Override
    public ParticipantStatus convert(String s) {
        return ParticipantStatus.valueOf(s);

    }
}
