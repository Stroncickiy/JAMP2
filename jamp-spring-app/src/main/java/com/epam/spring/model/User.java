package com.epam.spring.model;

import com.epam.spring.enums.UserRole;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 3, max = 15)
    @NotNull
    private String firstName;
    @Size(min = 3, max = 15)
    @NotNull
    private String lastName;
    @Size(min = 5, max = 20)
    @NotNull
    private String email;
    @Min(1)
    @Max(5)
    @NotNull
    private Integer level;
    @NotNull
    @Size(min = 1, max = 8)
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
    @OneToMany
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public List<ParticipantAssignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<ParticipantAssignment> assignments) {
        this.assignments = assignments;
    }

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

    public User getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(User lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }


}
