package com.epam.spring.controller;

import com.epam.spring.model.User;
import com.epam.spring.service.UserService;
import com.epam.spring.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private UserService userService;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String allUsersPage(Model model) {
		model.addAttribute("users", userService.getAll());
		return "users";
	}


	@RequestMapping(path = "edit/{userId}", method = RequestMethod.GET)
	public String openUpdateUserData(Model model, @PathVariable Long userId) {
		if(!model.containsAttribute("userToEdit")){
			model.addAttribute("userToEdit", userService.getById(userId));
		}
		return "editUser";
	}

	@RequestMapping(path = "edit", method = RequestMethod.POST)
	public ModelAndView updateUserData(@ModelAttribute User userToEdit,BindingResult bindingResult,Model model) {
		ModelAndView modelAndView = new ModelAndView("editUser",model.asMap());
		if (bindingResult.hasErrors()) {
			model.addAttribute("userToEdit",userToEdit);
			model.addAttribute("validationErrors", bindingResult.getAllErrors());			
			return modelAndView;
		}
		User currentUser = userService.getById(userToEdit.getId());
		if (currentUser != null) {
			currentUser.updateFields(userToEdit);
			userService.update(currentUser);
			return new ModelAndView(new RedirectView("/users/all"));
		}
		return modelAndView; 
	}

	@RequestMapping(path = "remove/{userId}")
	public String removeUser(@PathVariable("userId") Long id) {
		userService.remove(userService.getById(id));
		return "redirect:/users/all";
	}

}
