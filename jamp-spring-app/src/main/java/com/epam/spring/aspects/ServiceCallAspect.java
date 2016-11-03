package com.epam.spring.aspects;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.epam.spring.model.User;
import com.epam.spring.service.UserService;

@Aspect
@Component
public class ServiceCallAspect {
	private static Logger LOG = LoggerFactory.getLogger(ServiceCallAspect.class);
	@Autowired
	private UserService userService;

	@Before("within(com.epam.spring.service.impl..*)")
	public void logServiceCall(JoinPoint joinPoint) {
		LOG.info("[AOP] initiated Service call {}", joinPoint);
	}

	@AfterThrowing(pointcut = "within(com.epam.spring.service.impl..*)", throwing = "exception")
	public void logServiceCallAfterThrowing(JoinPoint joinPoint, Exception exception) {
		LOG.error("[AOP] Service call  {} threw exception {} ", joinPoint, exception.getMessage());
	}

	@Before(value = "execution(* com.epam.spring.service.impl.UserServiceImpl.add(..))")
	public void beforeAddUser(JoinPoint joinPoint) {
		User item = (User) joinPoint.getArgs()[0];
		LOG.info("[AOP]  add user {}", item);
		item.setCreationTime(new Date());
		item.setLastUpdatedTime(new Date());
		item.setLastUpdatedBy(item);
	}

	@Before(value = "execution(* com.epam.spring.service.impl.UserServiceImpl.update(..))")
	public void beforeUpdateUser(JoinPoint joinPoint) {
		User item = (User) joinPoint.getArgs()[0];
		LOG.info("[AOP]  update user {}", item);
		item.setLastUpdatedTime(new Date());
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		item.setLastUpdatedBy(userService.getUserByEmail(user.getUsername()));
	}

}
