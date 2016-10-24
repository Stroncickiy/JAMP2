package com.epam.spring.model;

import com.epam.spring.enums.UserRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Data
@ToString(of = {"id", "firstName", "lastName", "email", "level"})
@EqualsAndHashCode(of = {"id"})
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
