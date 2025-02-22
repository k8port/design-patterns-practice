package com.k8port.patterns.behavioral.use_cases.weather_station;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.k8port.patterns.behavioral.observer.use_cases.weather_station.WeatherData;
import com.k8port.patterns.behavioral.observer.use_cases.weather_station.WeatherDisplay;
import com.k8port.patterns.behavioral.observer.use_cases.weather_station.WeatherStation;

class WeatherStationTest {

    @Test
    void shouldNotifyMultipleObservers() {
        WeatherStation station = new WeatherStation();
        WeatherDisplay display1 = new WeatherDisplay("Display 1");
        WeatherDisplay display2 = new WeatherDisplay("Display 2");

        station.attachObserver(display1);
        station.attachObserver(display2);

        station.setWeatherData(25.0f, 60.0f, 1013.0f);

        verify(display1).update(any(WeatherData.class));
        verify(display2).update(any(WeatherData.class));
    }
}
