package com.epam.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Lecture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String domainArea;
	private String topic;
	@OneToOne
	private PhaseParticipantAssignment lector;
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	@ManyToOne
	private MentorshipPhase phase;

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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public MentorshipPhase getPhase() {
		return phase;
	}

	public void setPhase(MentorshipPhase phase) {
		this.phase = phase;
	}

}
