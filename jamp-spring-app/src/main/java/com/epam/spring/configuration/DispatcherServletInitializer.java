package com.epam.spring.configuration;

import javax.servlet.Filter;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.epam.spring.jms.Destinations;

@SpringBootApplication
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SecurityConfig.class,EmailConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new CharacterEncodingFilter("UTF-8")};
    }

    @Bean
    public ActiveMQTopic simpleTopic() {
      return new ActiveMQTopic(Destinations.USER_ACTIONS_TOPIC);
    }
}