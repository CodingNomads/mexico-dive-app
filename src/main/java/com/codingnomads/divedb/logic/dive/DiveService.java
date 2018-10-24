package com.codingnomads.divedb.logic.dive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public Dive getById(Integer id) {
        return diveRepository.getById(id);
    }

    public List<Dive> getByDate(LocalDate date) {
        return diveRepository.getByDate(date);
    }

    public Integer deleteById(Integer id) {
        return diveRepository.deleteById(id);
    }
}
