package com.codingnomads.divedb.data;

import com.codingnomads.divedb.logic.Dive;
import com.codingnomads.divedb.logic.DiveRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryDiveRepository implements DiveRepository {

    private List<Dive> diveList;

    public InMemoryDiveRepository() {
        this.diveList = new ArrayList<>();

    }

    @Override
    public List<Dive> getAllDives() {
        return diveList;
    }

    @Override
    public Dive save(Dive dive) {
        diveList.add(dive);
        return diveList.get(diveList.indexOf(dive));
    }
}
