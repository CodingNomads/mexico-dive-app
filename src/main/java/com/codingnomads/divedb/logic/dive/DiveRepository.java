package com.codingnomads.divedb.logic.dive;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiveRepository {

    List<Dive> getAllDives();

    Dive save(Dive dive);

    Dive getById(Integer id);

    List<Dive> getByDate(LocalDate date);
}
