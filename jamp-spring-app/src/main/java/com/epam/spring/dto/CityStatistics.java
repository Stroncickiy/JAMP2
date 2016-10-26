package com.epam.spring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityStatistics {
    private String cityName;
    private int countOfPhases;
    private int countOfParticipants;
}
