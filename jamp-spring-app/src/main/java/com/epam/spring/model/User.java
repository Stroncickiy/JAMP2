package com.epam.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.epam.spring.enums.UserRole;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(of = { "id", "firstName", "lastName", "email", "level" })
@EqualsAndHashCode(of = { "id" })
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Size(min = 3, max = 30)
	@NotNull
	private String firstName;
	@Size(min = 3, max = 30)
	@NotNull
	private String lastName;
	@Size(min = 5, max = 30)
	@NotNull
	private String email;
	@Min(1)
	@Max(5)
	@NotNull
	private Integer level;
	@NotNull
	@Size(min = 1, max = 30)
	private String primarySkill;
	@OneToOne
	private User manager;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private Date birthDate;
	private boolean enabled;
	@Size(min = 6)
	private String password;
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = UserRole.class)
	@Size(min = 1, max = 2)
	private List<UserRole> roles;
	@OneToMany(fetch = FetchType.LAZY)
	private List<ParticipantAssignment> assignments;
	@OneToOne
	private User lastUpdatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@Past
	private Date creationTime;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@Past
	private Date lastUpdatedTime;

	public void updateFields(User userDTO) {
		if (userDTO.getFirstName() != null) {
			setFirstName(userDTO.getFirstName());
		}
		if (userDTO.getLastName() != null) {
			setLastName(userDTO.getLastName());
		}

		if (userDTO.getBirthDate() != null) {
			setBirthDate(userDTO.getBirthDate());
		}

	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

}
