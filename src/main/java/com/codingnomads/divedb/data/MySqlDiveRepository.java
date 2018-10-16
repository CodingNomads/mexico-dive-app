package com.codingnomads.divedb.data;

import com.codingnomads.divedb.logic.Dive;
import com.codingnomads.divedb.logic.DiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Primary
@Repository
public class MySqlDiveRepository implements DiveRepository {

    private static final String TABLE_NAME = "dives";
    private static final String ALL_FIELDS = "*";
    private final DiveRowMapper rowMapper = new DiveRowMapper();

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlDiveRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Dive> getAllDives() {
        return jdbcTemplate.query("SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME, rowMapper);
    }

    @Override
    public Dive save(Dive dive) {
        String query = "INSERT INTO " + TABLE_NAME +
                " VALUES(null, :name, :date, :location, :durationInMinutes," +
                "        :maxDepthInMeters, :waterCondition, :safetyStop  )";
        KeyHolder key = new GeneratedKeyHolder();
        jdbcTemplate.update(query, createParametersFrom(dive), key);
        dive.setId(key.getKey().intValue());
        return dive;
    }

    @Override
    public Dive getById(Integer id) {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + " c_id = :id ";
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    @Override
    public List<Dive> getByDate(LocalDate date) {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + " c_date = :date ";
        return jdbcTemplate.query(query, rowMapper, date);
    }

    private Map<String, Object> createParametersFrom(Dive dive) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", dive.getName());
        parameters.put("date", dive.getDate());
        parameters.put("location", dive.getLocation());
        parameters.put("durationInMinutes", dive.getDurationInMinutes());
        parameters.put("maxDepthInMeters", dive.getMaxDepthInMeters());
        parameters.put("waterCondition", dive.getWaterCondition());
        parameters.put("safetyStop", dive.getSafetyStop());
        return parameters;
    }

}
