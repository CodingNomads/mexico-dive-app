package com.codingnomads.divedb.presentation;

import com.codingnomads.divedb.logic.Weather;
import com.codingnomads.divedb.logic.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/location/{location}")
    public Weather getResult(@PathVariable("location") String location) {
        return weatherService.getResult(location);
    }


}
