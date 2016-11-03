package com.epam.spring.app;

import org.springframework.boot.builder.SpringApplicationBuilder;

import com.epam.spring.configuration.DispatcherServletInitializer;

public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(DispatcherServletInitializer.class).run(args);
	}

}
