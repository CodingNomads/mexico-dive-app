package com.codingnomads.divedb.data;

import com.codingnomads.divedb.logic.Dive;
import com.codingnomads.divedb.logic.DiveRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryDiveRepository implements DiveRepository {

    private List<Dive> diveList;
    private Integer id = 0;

    public InMemoryDiveRepository() {
        this.diveList = new ArrayList<>();

    }

    @Override
    public List<Dive> getAllDives() {
        return diveList;
    }

    @Override
    public Dive save(Dive dive) {
        dive.setId(id++);
        diveList.add(dive);
        return diveList.get(diveList.indexOf(dive));
    }

    @Override
    public Dive getById(Integer id) {
        return diveList.stream()
                .filter(dive -> dive.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("This Dive doesn't Exist with id: " + id));
    }

    @Override
    public List<Dive> getByDate(LocalDate date) {
        return diveList.stream()
                .filter(dive -> dive.getDate().equals(date))
                .collect(Collectors.toList());
    }
}
