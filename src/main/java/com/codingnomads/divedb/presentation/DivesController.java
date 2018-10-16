package com.codingnomads.divedb.presentation;

import com.codingnomads.divedb.logic.Dive;
import com.codingnomads.divedb.logic.DiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/users/logbook/dives")
public class DivesController {
    private DiveService diveService;

    @Autowired
    public DivesController(DiveService diveService) {
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
