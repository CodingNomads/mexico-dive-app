package com.codingnomads.divedb.presentation.web;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HomeController {

    @Cacheable
    @GetMapping({"/","/home"})
    public String home(Model model) {
        model.addAttribute("date", LocalDate.now());
        return "home";
    }

}
