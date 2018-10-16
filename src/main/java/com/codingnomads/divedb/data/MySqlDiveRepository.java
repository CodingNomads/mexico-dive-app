package com.codingnomads.divedb.data;

import com.codingnomads.divedb.logic.Dive;
import com.codingnomads.divedb.logic.DiveRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//@Repository
public class MySqlDiveRepository implements DiveRepository {




    @Override
    public List<Dive> getAllDives() {
        return null;
    }

    @Override
    public Dive save(Dive dive) {
      //  int result = jdbcTemplate.queryForObject(
         //       "SELECT COUNT(*) FROM EMPLOYEE", Integer.class);

        return null;
    }

    @Override
    public Dive getById(Integer id) {
        return null;
    }

    @Override
    public List<Dive> getByDate(LocalDate date) {
        return null;
    }
}
