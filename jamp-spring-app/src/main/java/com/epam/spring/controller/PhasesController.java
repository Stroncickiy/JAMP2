package com.epam.spring.controller;

import com.epam.spring.dto.CityStatistics;
import com.epam.spring.dto.CompletionStatistics;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.service.MentorshipPhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/phases")
public class PhasesController {
    @Autowired
    private MentorshipPhaseService mentorshipPhaseService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView showAllPhases(ModelAndView modelAndView) {
        modelAndView.setViewName("phases");
        modelAndView.addObject("phases", mentorshipPhaseService.getAll());
        return modelAndView;

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addNewPhasePage(ModelAndView modelAndView) {
        modelAndView.setViewName("addNewPhase");
        modelAndView.addObject("phaseToAdd", new MentorshipPhase());
        return modelAndView;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addNewPhase(@Valid @ModelAttribute MentorshipPhase phaseToAdd, BindingResult bindingResult,
                                    Model model) {
        ModelAndView modelAndView = new ModelAndView("addNewPhase", model.asMap());
        if (bindingResult.hasErrors()) {
            model.addAttribute("phaseToAdd", phaseToAdd);
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return modelAndView;
        }
        mentorshipPhaseService.add(phaseToAdd);
        return new ModelAndView(new RedirectView("/phases/all"));

    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public ModelAndView getMentorshipPhasesStatistics() {
        ModelAndView modelAndView = new ModelAndView("phasesByCities"); // TODO create view
        List<CityStatistics> statisticByCities = mentorshipPhaseService.getStatisticsForEachCity();
        modelAndView.addObject("statistics", statisticByCities);
        return modelAndView;
    }

    @RequestMapping(value = "/completionStatistics", method = RequestMethod.GET)
    public ModelAndView getCompletionStatistics(Date from, Date to) {
        ModelAndView modelAndView = new ModelAndView("completionStatistics"); // TODO create view
        CompletionStatistics completionStatistics = mentorshipPhaseService.getCompletionStatisticsForPeriod(from,to);
        modelAndView.addObject("completionStatistics", completionStatistics);
        return modelAndView;
    }


}
