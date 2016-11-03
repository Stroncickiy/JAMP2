package com.epam.spring.converter;


import org.springframework.core.convert.converter.Converter;

import com.epam.spring.enums.GroupStatus;

public class GroupStatusConverter implements Converter<String, GroupStatus> {
    @Override
    public GroupStatus convert(String s) {
        return GroupStatus.valueOf(s);
    }
}
