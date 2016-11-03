package com.epam.spring.converter;


import org.springframework.core.convert.converter.Converter;

import com.epam.spring.enums.ParticipantRole;

public class ParticipantRoleConverter implements Converter<String, ParticipantRole> {
    @Override
    public ParticipantRole convert(String s) {
        return ParticipantRole.valueOf(s);
    }
}
