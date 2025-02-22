package com.k8port.patterns.behavioral.observer.use_cases.weather_station;

import com.k8port.patterns.behavioral.observer.Subject;

public class WeatherStation extends Subject<WeatherData> {

    public void setWeatherData(float temperature, float humidity, float pressure) {
        WeatherData weatherData = new WeatherData(temperature, humidity, pressure);
        notifyObservers(weatherData);
    }
}
