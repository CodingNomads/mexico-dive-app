package com.codingnomads.divedb.presentation.web;

import com.codingnomads.divedb.logic.dive.DiveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.time.LocalDate;

@Controller
public class HomeController {

    @Resource
    private DiveService diveService;


    @GetMapping("/home")
    public String welcome(Model model) {
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("dives", diveService.getAllDives());

        return "home";
    }

}
