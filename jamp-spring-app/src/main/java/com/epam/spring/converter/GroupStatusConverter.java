package com.epam.spring.converter;


import com.epam.spring.enums.GroupStatus;
import org.springframework.core.convert.converter.Converter;

public class GroupStatusConverter implements Converter<String, GroupStatus> {
    @Override
    public GroupStatus convert(String s) {
        return GroupStatus.valueOf(s);
    }
}
