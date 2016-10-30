package com.epam.spring.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Data
@Entity
@Builder
public class RequestEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String method;
    private String path;
    @ElementCollection
    @MapKeyColumn(name = "param")
    @Column(name = "value")
    @CollectionTable(name = "rq_params", joinColumns = @JoinColumn(name = "rq_id"))
    private Map<String, String> params;
    private String requestBody;
    private String callerAddress;
    private String responseBody;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @PrePersist
    public void prePersist() {
        timestamp = new Date();
    }

}
