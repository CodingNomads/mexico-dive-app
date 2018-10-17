package com.codingnomads.divedb.logic;

import com.codingnomads.divedb.data.ApiWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private ApiWeatherRepository apiWeatherRepository;

    @Autowired
    public WeatherService(ApiWeatherRepository apiWeatherRepository) {
        this.apiWeatherRepository = apiWeatherRepository;
    }

    public Weather getResult(String location){
        return apiWeatherRepository.getWeather(location);
    }
}
