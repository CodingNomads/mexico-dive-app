package com.codingnomads.divedb.presentation.web;

import com.codingnomads.divedb.logic.dive.Dive;
import com.codingnomads.divedb.logic.dive.DiveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class DivesController {
    @Resource
    private DiveService diveService;

    @GetMapping("/dives")
    public ModelAndView dives(ModelAndView modelAndView) {
        modelAndView.addObject("dives", diveService.getAllDives());
        modelAndView.setViewName("dives");
        return modelAndView;
    }

    @GetMapping("/dives/new")
    public String newDiveForm(Model model) {
        model.addAttribute("dive", new Dive());
        return "newDive";
    }

    @PostMapping("/dives/new")
    public String newDiveSubmit(@ModelAttribute Dive dive) {
        System.out.println("saved " + diveService.save(dive));
        return "newDive";
    }

    @GetMapping("/dives/delete/{id}")
    public String deleteDive(@PathVariable(name = "id") int id) {
        System.out.println("deleted " + diveService.deleteById(id));
        return "redirect:/dives";
    }
}
