package com.epam.spring.controller;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.spring.app.enums.UserRole;
import com.epam.spring.model.User;
import com.epam.spring.service.UserService;

@Controller
public class AuthController {

	@Autowired
	private UserService userService;

	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void init() {
		passwordEncoder = new BCryptPasswordEncoder();
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/denied")
	public String accessDeniedPage() {
		return "denied";
	}

	@RequestMapping(value = "/logout")
	public String logout() {
		SecurityContextHolder.clearContext();
		return "/login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String openRegisterPage(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("availableRoles", UserRole.values());
		return "register";
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("newUser") User user) {
		user.setRoles(user.getRoles());
		user.setBirthDate(user.getBirthDate());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		userService.add(user);
		return "redirect:/";
	}

}
