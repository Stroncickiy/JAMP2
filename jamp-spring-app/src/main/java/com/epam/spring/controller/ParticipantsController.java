package com.epam.spring.controller;

import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.enums.ParticipantStatus;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.model.ParticipantAssignment;
import com.epam.spring.service.MentorshipPhaseService;
import com.epam.spring.service.ParticipantService;
import com.epam.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/participants")
public class ParticipantsController {
    @Autowired
    private ParticipantService participantsService;

    @Autowired
    private UserService userService;

    @Autowired
    private MentorshipPhaseService phaseService;

    @RequestMapping(value = "/{phaseId}", method = RequestMethod.GET)
    public ModelAndView showParticipantsOfPhase(@PathVariable("phaseId") Long phaseId, ModelAndView modelAndView) {
        modelAndView.setViewName("participants");
        MentorshipPhase targetMentorshipPhase = phaseService.getById(phaseId);
        modelAndView.addObject("targetMentorshipPhase", targetMentorshipPhase);
        modelAndView.addObject("participants", participantsService.getParticipantsForPhase(targetMentorshipPhase));
        return modelAndView;

    }

    @RequestMapping(value = "/add/{phaseId}", method = RequestMethod.GET)
    public ModelAndView addNewParticipantPage(ModelAndView modelAndView, @PathVariable("phaseId") Long phaseId) {

        modelAndView.addObject("users", userService.getAll());
        modelAndView.addObject("roles", ParticipantRole.values());
        modelAndView.addObject("statuses", ParticipantStatus.values());

        modelAndView.setViewName("addNewParticipant");
        MentorshipPhase phase = phaseService.getById(phaseId);
        ParticipantAssignment participantAssignment = new ParticipantAssignment();
        participantAssignment.setPhase(phase);
        modelAndView.addObject("participantToAdd",participantAssignment );
        return modelAndView;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addNewParticipant(@ModelAttribute ParticipantAssignment participantAssignmentToAdd, BindingResult bindingResult,
                                    Model model) {
        ModelAndView modelAndView = new ModelAndView("addNewParticipant", model.asMap());
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("users", userService.getAll());
            modelAndView.addObject("roles", ParticipantRole.values());
            modelAndView.addObject("statuses", ParticipantStatus.values());

            model.addAttribute("participantToAdd", participantAssignmentToAdd);
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return modelAndView;
        }
        participantsService.add(participantAssignmentToAdd);
        return new ModelAndView(new RedirectView("/participants/"+participantAssignmentToAdd.getPhase().getId()));

    }
}
