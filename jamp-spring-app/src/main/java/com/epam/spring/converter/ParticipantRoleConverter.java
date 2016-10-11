package com.epam.spring.converter;


import com.epam.spring.enums.ParticipantRole;
import org.springframework.core.convert.converter.Converter;

public class ParticipantRoleConverter implements Converter<String, ParticipantRole> {
    @Override
    public ParticipantRole convert(String s) {
        return ParticipantRole.valueOf(s);
    }
}
