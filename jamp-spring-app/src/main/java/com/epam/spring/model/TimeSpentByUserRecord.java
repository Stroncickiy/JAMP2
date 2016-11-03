package com.epam.spring.model;

import lombok.Data;

@Data
public class TimeSpentByUserRecord {
	private String email;
	private Long timeSpent;
}
