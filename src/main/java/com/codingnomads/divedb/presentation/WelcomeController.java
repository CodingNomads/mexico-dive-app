package com.codingnomads.divedb.presentation;

import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(@RequestParam(value = "name", defaultValue = "misterious guy") String name) {
        return "Welcome " + name;
    }
}
