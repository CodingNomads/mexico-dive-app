package com.codingnomads.divedb.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
public class AnimalsController {

    @GetMapping("/animals")
    public List<Animal> getAllAnimals() {
        return asList(new Animal("Lion Fish"), new Animal("Green Eel"));
    }
}
