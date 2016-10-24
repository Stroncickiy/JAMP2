package com.epam.spring.controller;

import com.epam.spring.enums.GroupStatus;
import com.epam.spring.enums.ParticipantRole;
import com.epam.spring.model.MentorshipGroup;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.service.MentorshipGroupService;
import com.epam.spring.service.MentorshipPhaseService;
import com.epam.spring.service.ParticipantService;
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

import javax.validation.Valid;

@Controller
@RequestMapping("/groups")
public class MentorshipGroupController {
    @Autowired
    private MentorshipPhaseService phaseService;
    @Autowired
    private MentorshipGroupService mentorshipGroupService;
    @Autowired
    private ParticipantService participantsService;

    @RequestMapping(value = "/{phaseId}", method = RequestMethod.GET)
    public ModelAndView shows(ModelAndView modelAndView, @PathVariable("phaseId") Long phaseId) {
        MentorshipPhase targetMentorshipPhase = phaseService.getById(phaseId);
        modelAndView.setViewName("groups");
        modelAndView.addObject("groups", mentorshipGroupService.getForPhase(targetMentorshipPhase));
        modelAndView.addObject("targetMentorshipPhase", targetMentorshipPhase);
        return modelAndView;
    }

    @RequestMapping(value = "/add/{phaseId}", method = RequestMethod.GET)
    public ModelAndView addNeGroupPage(ModelAndView modelAndView, @PathVariable("phaseId") Long phaseId) {
        modelAndView.setViewName("addNewGroup");
        MentorshipPhase phase = phaseService.getById(phaseId);
        MentorshipGroup mentorshipGroupToAdd = new MentorshipGroup();
        mentorshipGroupToAdd.setStatus(GroupStatus.INITIATION);
        mentorshipGroupToAdd.setPhase(phase);

        modelAndView.addObject("targetMentorshipPhase", phase);
        modelAndView.addObject("groupToAdd", mentorshipGroupToAdd);

        modelAndView.addObject("mentors", participantsService.getParticipantsForPhaseByRole(phase, ParticipantRole.MENTOR));
        modelAndView.addObject("mentees", participantsService.getParticipantsForPhaseByRole(phase, ParticipantRole.MENTEE));


        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addNew(@Valid @ModelAttribute MentorshipGroup groupToAdd, BindingResult bindingResult, Model model) {
        ModelAndView modelAndView = new ModelAndView("addNewGroup", model.asMap());
        if (bindingResult.hasErrors()) {
            MentorshipPhase phase = phaseService.getById(groupToAdd.getPhase().getId());
            modelAndView.addObject("targetMentorshipPhase", phase);
            modelAndView.addObject("groupToAdd", groupToAdd);
            modelAndView.addObject("mentors", participantsService.getParticipantsForPhaseByRole(phase, ParticipantRole.MENTOR));
            modelAndView.addObject("mentees", participantsService.getParticipantsForPhaseByRole(phase, ParticipantRole.MENTEE));

            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return modelAndView;
        }
        mentorshipGroupService.add(groupToAdd);
        return new ModelAndView(new RedirectView("/groups/" + groupToAdd.getPhase().getId()));
    }


    @RequestMapping(value = "/update/{groupId}", method = RequestMethod.GET)
    public ModelAndView updateGroupPage(ModelAndView modelAndView, @PathVariable("groupId") Long groupId) {
        modelAndView.setViewName("updateGroup");
        MentorshipGroup mentorshipGroupToUpdate = mentorshipGroupService.getById(groupId);

        modelAndView.addObject("groupToUpdate", mentorshipGroupToUpdate);
        modelAndView.addObject("statuses", GroupStatus.values());
        modelAndView.addObject("mentors", participantsService.getParticipantsForPhaseByRole(mentorshipGroupToUpdate.getPhase(), ParticipantRole.MENTOR));
        modelAndView.addObject("mentees", participantsService.getParticipantsForPhaseByRole(mentorshipGroupToUpdate.getPhase(), ParticipantRole.MENTEE));

        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateGroup(@Valid @ModelAttribute MentorshipGroup groupToUpdate, BindingResult bindingResult, Model model) {
        ModelAndView modelAndView = new ModelAndView("updateGroup", model.asMap());
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("groupToUpdate", groupToUpdate);
            modelAndView.addObject("mentors", participantsService.getParticipantsForPhaseByRole(groupToUpdate.getPhase(), ParticipantRole.MENTOR));
            modelAndView.addObject("mentees", participantsService.getParticipantsForPhaseByRole(groupToUpdate.getPhase(), ParticipantRole.MENTEE));
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return modelAndView;
        }
        mentorshipGroupService.update(groupToUpdate);
        return new ModelAndView(new RedirectView("/groups/" + groupToUpdate.getPhase().getId()));
    }

    @RequestMapping(value = "/remove/{groupId}", method = RequestMethod.GET)
    public ModelAndView deleteLecture(@PathVariable("groupId") Long groupId) {
        MentorshipGroup groupToDelete = mentorshipGroupService.getById(groupId);
        mentorshipGroupService.remove(groupToDelete);
        return new ModelAndView(new RedirectView("/groups/" + groupToDelete.getPhase().getId()));

    }


}
