package com.epam.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class RequestEntry implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6684463412433277893L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String request;
    private String response;
}
