package com.codingnomads.divedb.logic;

public interface WeatherRepository {
    Weather getWeather(String location);
}
