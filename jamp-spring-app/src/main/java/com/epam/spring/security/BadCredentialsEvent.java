package com.epam.spring.security;

import org.springframework.context.ApplicationEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BadCredentialsEvent extends ApplicationEvent {
	private String username;
	private String ip;

	public BadCredentialsEvent(Object source, String username, String ip) {
		super(source);
		this.username = username;
		this.ip = ip;
	}

	private static final long serialVersionUID = 1L;

}
