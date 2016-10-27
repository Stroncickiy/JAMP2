package com.epam.spring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompletionStatistics {
    private Long countOfAllMentees;
    private Long countOfSuccessfulGraduations;
    private Double successPercentage;
}
