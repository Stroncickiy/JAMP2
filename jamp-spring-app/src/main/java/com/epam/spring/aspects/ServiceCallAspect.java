package com.epam.spring.aspects;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.epam.spring.model.User;
import com.epam.spring.service.UserService;

@Aspect
@Component
public class ServiceCallAspect {
	@Autowired
	private UserService userService;

	@Before("within(com.epam.spring.service.impl..*)")
	public void logServiceCall(JoinPoint joinPoint) {
		System.out.println("[AOP]" + joinPoint);
	}

	@Before(value = "execution(* com.epam.spring.service.impl.UserServiceImpl.add(..))")
	public void beforeAddUser(JoinPoint joinPoint) {
		User item = (User) joinPoint.getArgs()[0];
		System.out.println("[AOP]  add user " + item);
		item.setCreationTime(new Date());
		item.setLastUpdatedTime(new Date());
		item.setLastUpdatedBy(item);
	}

	@Before(value = "execution(* com.epam.spring.service.impl.UserServiceImpl.update(..))")
	public void beforeUpdateUser(JoinPoint joinPoint) {
		User item = (User) joinPoint.getArgs()[0];
		System.out.println("[AOP]  updating user " + item);
		item.setLastUpdatedTime(new Date());
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		item.setLastUpdatedBy(userService.getUserByEmail(user.getUsername()));
	}

}
