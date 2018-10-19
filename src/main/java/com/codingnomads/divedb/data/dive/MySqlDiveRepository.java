package com.codingnomads.divedb.data.dive;

import com.codingnomads.divedb.logic.dive.Dive;
import com.codingnomads.divedb.logic.dive.DiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Primary
@Repository
public class MySqlDiveRepository implements DiveRepository {

    private static final String TABLE_NAME = "dives";
    private static final String ALL_FIELDS = "*";
    private final DiveRowMapper rowMapper = new DiveRowMapper();

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlDiveRepository(NamedParameterJdbcTemplate jdbcTemplate) {
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
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(dive);
        jdbcTemplate.update(query, namedParameters, key);
        dive.setId(key.getKey().intValue());
        return dive;
    }

    @Override
    public Dive getById(Integer id) {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + "d_id = :id ";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
    }

    @Override
    public List<Dive> getByDate(LocalDate date) {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + " d_date = :date ";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("date", date);
        return jdbcTemplate.query(query, namedParameters, rowMapper);
    }


}
