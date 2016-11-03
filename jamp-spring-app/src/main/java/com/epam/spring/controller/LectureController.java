package com.epam.spring.controller;

import javax.validation.Valid;

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

import com.epam.spring.model.Lecture;
import com.epam.spring.model.MentorshipPhase;
import com.epam.spring.service.LectureService;
import com.epam.spring.service.MentorshipPhaseService;
import com.epam.spring.service.ParticipantService;

@Controller
@RequestMapping("/lectures")
public class LectureController {
    @Autowired
    private LectureService lectureService;
    @Autowired
    private MentorshipPhaseService phaseService;
    @Autowired
    private ParticipantService participantsService;

    @RequestMapping(value = "/{phaseId}", method = RequestMethod.GET)
    public ModelAndView showLecturesOfPhase(ModelAndView modelAndView, @PathVariable("phaseId") Long phaseId) {
        MentorshipPhase targetMentorshipPhase = phaseService.getById(phaseId);
        modelAndView.setViewName("lectures");
        modelAndView.addObject("lectures", lectureService.getForPhase(targetMentorshipPhase));
        modelAndView.addObject("targetMentorshipPhase", targetMentorshipPhase);
        return modelAndView;
    }

    @RequestMapping(value = "/add/{phaseId}", method = RequestMethod.GET)
    public ModelAndView addNewLecturePage(ModelAndView modelAndView, @PathVariable("phaseId") Long phaseId) {
        modelAndView.setViewName("addNewLecture");
        MentorshipPhase phase = phaseService.getById(phaseId);
        modelAndView.addObject("lectors", participantsService.getLectorsForPhase(phase));
        Lecture lectureToAdd = new Lecture();
        lectureToAdd.setPhase(phaseService.getById(phaseId));
        modelAndView.addObject("lectureToAdd", lectureToAdd);
        return modelAndView;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addNewLecture(@Valid @ModelAttribute Lecture lectureToAdd, BindingResult bindingResult, Model model) {
        ModelAndView modelAndView = new ModelAndView("addNewLecture", model.asMap());
        if (bindingResult.hasErrors()) {
            model.addAttribute("lectors", participantsService.getLectorsForPhase(lectureToAdd.getPhase()));
            model.addAttribute("lectureToAdd", lectureToAdd);
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return modelAndView;
        }
        lectureService.add(lectureToAdd);
        return new ModelAndView(new RedirectView("/lectures/" + lectureToAdd.getPhase().getId()));

    }

    @RequestMapping(value = "/update/{lectureId}", method = RequestMethod.GET)
    public ModelAndView updateLecturePage(ModelAndView modelAndView, @PathVariable("lectureId") Long lectureId) {
        modelAndView.setViewName("updateLecture");
        Lecture lectureToUpdate = lectureService.getById(lectureId);
        modelAndView.addObject("lectors", participantsService.getLectorsForPhase(lectureToUpdate.getPhase()));
        modelAndView.addObject("lectureToUpdate", lectureToUpdate);
        return modelAndView;
    }

    @RequestMapping(value = "/remove/{lectureId}", method = RequestMethod.GET)
    public ModelAndView deleteLecture(@PathVariable("lectureId") Long lectureId) {
        Lecture lectureToDelete = lectureService.getById(lectureId);
        lectureService.remove(lectureToDelete);
        return new ModelAndView(new RedirectView("/lectures/" + lectureToDelete.getPhase().getId()));

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateLecture(@Valid  @ModelAttribute Lecture lectureToUpdate, BindingResult bindingResult, Model model) {
        ModelAndView modelAndView = new ModelAndView("updateLecture", model.asMap());
        if (bindingResult.hasErrors()) {
            model.addAttribute("lectors", participantsService.getLectorsForPhase(lectureToUpdate.getPhase()));
            model.addAttribute("lectureToUpdate", lectureToUpdate);
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return modelAndView;
        }
        lectureService.update(lectureToUpdate);
        return new ModelAndView(new RedirectView("/lectures/" + lectureToUpdate.getPhase().getId()));
    }

}
