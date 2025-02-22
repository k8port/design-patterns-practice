package com.k8port.patterns.behavioral.observer.use_cases.weather_station;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.k8port.patterns.behavioral.observer.Observer;

public class WeatherDisplay implements Observer<WeatherData> {
    private static final Logger logger = LoggerFactory.getLogger(WeatherDisplay.class);
    private final String displayName;

    public WeatherDisplay(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public void update(WeatherData data) {
        logger.info("{}: Temperature: {:.1f}°C, Humidity: {:.1f}%, Pressure: {:.1f} hPa",
            displayName, data.temperature(), data.humidity(), data.pressure());
    }
}
