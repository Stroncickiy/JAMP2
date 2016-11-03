package com.epam.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.spring.enums.UserRole;
import com.epam.spring.model.User;
import com.epam.spring.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;


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
        userService.add(user);
        return "redirect:/";
    }

}
