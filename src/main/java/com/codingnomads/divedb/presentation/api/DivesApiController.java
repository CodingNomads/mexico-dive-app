package com.codingnomads.divedb.presentation.api;

import com.codingnomads.divedb.logic.dive.Dive;
import com.codingnomads.divedb.logic.dive.DiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/users/logbook/dives")
public class DivesApiController {
    private DiveService diveService;

    @Autowired
    public DivesApiController(DiveService diveService) {
        this.diveService = diveService;
    }

    @GetMapping
    public List<Dive> getAll() {
        return diveService.getAllDives();
    }

    @PostMapping
    public Dive save(@RequestBody Dive dive){
        return diveService.save(dive);
    }

    @GetMapping("/{id}")
    public Dive getById(@PathVariable Integer id){
        return diveService.getById(id);
    }

    @GetMapping("/date/{date}")
    public List<Dive> getByDate(@PathVariable String date){
        return diveService.getByDate(LocalDate.parse(date));
    }

}
