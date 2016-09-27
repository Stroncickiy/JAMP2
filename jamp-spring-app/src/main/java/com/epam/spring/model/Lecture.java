package com.epam.spring.model;

import java.time.LocalDateTime;

import javax.persistence.Id;

public class Lecture {
	@Id
	private Long id;
	private String domainArea;
	private String topic;
	private PhaseParticipantAssignment lector;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDomainArea() {
		return domainArea;
	}

	public void setDomainArea(String domainArea) {
		this.domainArea = domainArea;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public PhaseParticipantAssignment getLector() {
		return lector;
	}

	public void setLector(PhaseParticipantAssignment lector) {
		this.lector = lector;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

}
