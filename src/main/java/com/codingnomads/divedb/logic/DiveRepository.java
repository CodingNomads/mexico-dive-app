package com.codingnomads.divedb.logic;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiveRepository {

    List<Dive> getAllDives();

    Dive save(Dive dive);
}
