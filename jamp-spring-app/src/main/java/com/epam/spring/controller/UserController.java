package com.epam.spring.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.epam.spring.model.TimeSpentByUserRecord;
import com.epam.spring.model.User;
import com.epam.spring.pdf.SiteUsagePdfCreator;
import com.epam.spring.service.UserService;
import com.epam.spring.validator.UserValidator;

@Controller
@RequestMapping("users")
public class UserController {

	private static Logger LOG = LoggerFactory.getLogger(UserController.class);

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
		if (!model.containsAttribute("userToEdit")) {
			model.addAttribute("userToEdit", userService.getById(userId));
		}
		return "editUser";
	}

	@RequestMapping(path = "edit", method = RequestMethod.POST)
	public ModelAndView updateUserData(@Valid @ModelAttribute User userToEdit, BindingResult bindingResult,
			Model model) {
		ModelAndView modelAndView = new ModelAndView("editUser", model.asMap());
		if (bindingResult.hasErrors()) {
			model.addAttribute("userToEdit", userToEdit);
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

	@GetMapping(path = "usageStatistics", produces = "application/pdf")
	public ResponseEntity<byte[]> getSiteUsageStatisticsForPeriod(
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("from") LocalDate start,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("to") LocalDate end) {

		LocalDateTime from = start.atStartOfDay();
		LocalDateTime to = end.atTime(23, 59, 59);

		LOG.info("building site usage statistics from {} to {} ", from, to);
		List<TimeSpentByUserRecord> statisticsOfTimeSpentOnSiteForPeriod = userService
				.getStatisticsOfTimeSpentOnSiteForPeriod(from, to);
		LOG.info(statisticsOfTimeSpentOnSiteForPeriod.toString());
		byte[] statisticsInPdf = SiteUsagePdfCreator.createPdf(statisticsOfTimeSpentOnSiteForPeriod);
		return new ResponseEntity<>(statisticsInPdf, HttpStatus.OK);
	}

}
