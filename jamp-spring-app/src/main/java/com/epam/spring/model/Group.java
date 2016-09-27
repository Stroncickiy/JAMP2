package com.epam.spring.model;

import java.time.LocalDate;

import javax.persistence.Id;

import com.epam.spring.enums.GroupStatus;

public class Group {
	@Id
	private Long id;
	private PhaseParticipantAssignment mentor;
	private PhaseParticipantAssignment mentee;
	private LocalDate plannedStart;
	private LocalDate plannedEnd;
	private LocalDate actualStart;
	private LocalDate actualEnd;
	private GroupStatus status;

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

	public LocalDate getPlannedStart() {
		return plannedStart;
	}

	public void setPlannedStart(LocalDate plannedStart) {
		this.plannedStart = plannedStart;
	}

	public LocalDate getPlannedEnd() {
		return plannedEnd;
	}

	public void setPlannedEnd(LocalDate plannedEnd) {
		this.plannedEnd = plannedEnd;
	}

	public LocalDate getActualStart() {
		return actualStart;
	}

	public void setActualStart(LocalDate actualStart) {
		this.actualStart = actualStart;
	}

	public LocalDate getActualEnd() {
		return actualEnd;
	}

	public void setActualEnd(LocalDate actualEnd) {
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
