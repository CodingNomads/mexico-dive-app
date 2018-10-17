package com.codingnomads.divedb.data;

import com.codingnomads.divedb.logic.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;

@Repository
public class ApiWeatherRepository {

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String PATH = "weather";
    private static final String API_KEY = "9727f8d341a22a7983a08006f4a5261b";
    private static final String QUERY = "q";
    private static final String APPID = "APPID";

    private RestTemplate restTemplate;

    @Autowired
    public ApiWeatherRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Weather getWeather(String location) {
        URI uri = new DefaultUriBuilderFactory()
                .uriString(BASE_URL)
                .path(PATH)
                .queryParam(QUERY, location)
                .queryParam(APPID, API_KEY)
                .build();
        return restTemplate.getForEntity(uri, Weather.class).getBody();
    }

}