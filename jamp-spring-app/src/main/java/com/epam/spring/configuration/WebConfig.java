package com.epam.spring.configuration;

import com.epam.spring.converter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.format.FormatterRegistry;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.epam.spring.*")
@PropertySources({@PropertySource("classpath:app.properties"), @PropertySource("classpath:messages.properties")})
@EnableAsync
@EnableScheduling
@EnableAspectJAutoProxy
@EnableWebMvc
@EntityScan(basePackages = "com.epam.spring.model")
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
        registry.addConverter(new GroupStatusConverter());
        registry.addConverter(context.getBean(UserConverter.class));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
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
