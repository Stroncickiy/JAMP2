package com.epam.spring.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
public class InteractionEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User initiator;
    private String ip;
    private String method;
    private String path;
    @Column(length = 1024)
    private String requestHeaders;
    @Column(length = 1024)
    private String requestParams;
    @Column(length = 1024)
    private String requestBody;
    private Integer responseStatus;
    @Column(length = 1024)
    private String responseBody;
}
