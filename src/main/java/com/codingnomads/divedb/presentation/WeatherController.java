package com.codingnomads.divedb.presentation;

import com.codingnomads.divedb.logic.Weather;
import com.codingnomads.divedb.logic.WeatherService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WeatherController {
    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api")
    public Weather getResult(@Param("location") String location){
        return weatherService.getResult(location);
    }


}
