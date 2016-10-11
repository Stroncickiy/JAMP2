package com.epam.spring.configuration;

import com.epam.spring.converter.ParticipantConverter;
import com.epam.spring.converter.ParticipantRoleConverter;
import com.epam.spring.converter.ParticipantStatusConverter;
import com.epam.spring.converter.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.epam.spring.*")
@PropertySources({ @PropertySource("classpath:app.properties"), @PropertySource("classpath:messages.properties") })
@EnableAsync
@EnableScheduling
@EnableAspectJAutoProxy
@EntityScan(basePackages = { "com.epam.spring.model" })
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Value("${dateFormat}")
	private String dateFormat;

	@Autowired
	private ApplicationContext context;

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(context.getBean(ParticipantConverter.class));
		registry.addConverter(new ParticipantRoleConverter());
        registry.addConverter(new ParticipantStatusConverter());
        registry.addConverter(context.getBean(UserConverter.class));
		// converterAutoscanner(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}

	/*
	 * @SuppressWarnings("rawtypes") private void
	 * converterAutoscanner(FormatterRegistry formatterRegistry) { Reflections
	 * reflections = new Reflections("com.epam.spring.converter"); Set<Class<?
	 * extends Converter>> allClasses =
	 * reflections.getSubTypesOf(Converter.class); allClasses.forEach(s -> { try
	 * { formatterRegistry.addConverter(s.newInstance()); } catch (Exception e)
	 * { e.printStackTrace(); } }); }
	 */

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();

	}

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		return new TomcatEmbeddedServletContainerFactory();

	}

	@Bean
	public Executor taskExecutor() {
		return new SimpleAsyncTaskExecutor();
	}

}
