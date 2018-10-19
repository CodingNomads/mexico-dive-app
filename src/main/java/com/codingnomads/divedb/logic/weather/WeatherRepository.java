package com.codingnomads.divedb.logic.weather;

public interface WeatherRepository {
    Weather getWeather(String location);
}
