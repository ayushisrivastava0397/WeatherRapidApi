package weather.WeatherRapidAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import weather.WeatherRapidAPI.service.WeatherService;

import java.net.URI;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{locationName}")
    public ResponseEntity<String> getForecastSummary(@PathVariable String locationName) {
        try {
            return weatherService.getForecastSummaryByLocationName(locationName);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }

    @GetMapping("/hourly/{locationName}")
    public ResponseEntity<String> getHourlyForecastByLocationName(@PathVariable String locationName) {
        try {
            return weatherService.getHourlyForecastByLocationName(locationName);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }
}
