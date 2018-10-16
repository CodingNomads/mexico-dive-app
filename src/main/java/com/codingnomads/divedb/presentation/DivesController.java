package com.codingnomads.divedb.presentation;

import com.codingnomads.divedb.logic.Dive;
import com.codingnomads.divedb.logic.DiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DivesController {
    private DiveService diveService;

    @Autowired
    public DivesController(DiveService diveService) {
        this.diveService = diveService;
    }

    @GetMapping("/user/logbook/dives")
    public List<Dive> getAll() {
        return diveService.getAllDives();
    }

    @PostMapping("/user/logbook/dives")
    public Dive save(@RequestBody Dive dive){
        return diveService.save(dive);
    }
}
