package com.codingnomads.divedb.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class DiveService {

    private DiveRepository diveRepository;

    @Autowired
    public DiveService(DiveRepository diveRepository) {
        this.diveRepository = diveRepository;
    }

    public List<Dive> getAllDives() {
        return diveRepository.getAllDives();
    }

    public Dive save(Dive dive) {
        return diveRepository.save(dive);
    }
}
