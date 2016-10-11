package com.epam.spring.model;

import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;

import javax.persistence.*;

@Entity
public class ParticipantAssignment {
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
