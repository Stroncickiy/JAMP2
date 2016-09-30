package com.epam.spring.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.epam.spring.app.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;

@Entity
public class PhaseParticipantAssignment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private User assignee;
	private ParticipantRole role;
	@Enumerated(EnumType.STRING)
	private ParticipantStatus status;
	@ManyToOne
	private MentorshipPhase phase;

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public ParticipantRole getRole() {
		return role;
	}

	public void setRole(ParticipantRole role) {
		this.role = role;
	}

	public ParticipantStatus getStatus() {
		return status;
	}

	public void setStatus(ParticipantStatus status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MentorshipPhase getPhase() {
		return phase;
	}

	public void setPhase(MentorshipPhase phase) {
		this.phase = phase;
	}

}
