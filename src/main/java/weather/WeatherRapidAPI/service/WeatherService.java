package weather.WeatherRapidAPI.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface WeatherService {

    ResponseEntity<String> getForecastSummaryByLocationName(String cityName);

    public ResponseEntity<String> getHourlyForecastByLocationName(String Name);
}
