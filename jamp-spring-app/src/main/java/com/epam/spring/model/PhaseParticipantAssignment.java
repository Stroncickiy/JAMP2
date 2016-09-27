package com.epam.spring.model;

import javax.persistence.Id;

import com.epam.spring.app.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;

public class PhaseParticipantAssignment {
	@Id
	private Long id;
	private User assignee;
	private ParticipantRole role;
	private ParticipantStatus status;

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

}
