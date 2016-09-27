package com.epam.spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.epam.spring.enums.GroupStatus;

@Entity
public class MentorshipGroup  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private PhaseParticipantAssignment mentor;
	@OneToOne
	private PhaseParticipantAssignment mentee;
	@Temporal(TemporalType.DATE)
	private Date plannedStart;
	@Temporal(TemporalType.DATE)
	private Date plannedEnd;
	@Temporal(TemporalType.DATE)
	private Date actualStart;
	@Temporal(TemporalType.DATE)
	private Date actualEnd;
	@Enumerated(EnumType.STRING)
	private GroupStatus status;
	@ManyToOne
	private MentorshipPhase phase;

	public PhaseParticipantAssignment getMentor() {
		return mentor;
	}

	public void setMentor(PhaseParticipantAssignment mentor) {
		this.mentor = mentor;
	}

	public PhaseParticipantAssignment getMentee() {
		return mentee;
	}

	public void setMentee(PhaseParticipantAssignment mentee) {
		this.mentee = mentee;
	}

	public Date getPlannedStart() {
		return plannedStart;
	}

	public void setPlannedStart(Date plannedStart) {
		this.plannedStart = plannedStart;
	}

	public Date getPlannedEnd() {
		return plannedEnd;
	}

	public void setPlannedEnd(Date plannedEnd) {
		this.plannedEnd = plannedEnd;
	}

	public Date getActualStart() {
		return actualStart;
	}

	public void setActualStart(Date actualStart) {
		this.actualStart = actualStart;
	}

	public Date getActualEnd() {
		return actualEnd;
	}

	public void setActualEnd(Date actualEnd) {
		this.actualEnd = actualEnd;
	}

	public GroupStatus getStatus() {
		return status;
	}

	public void setStatus(GroupStatus status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
