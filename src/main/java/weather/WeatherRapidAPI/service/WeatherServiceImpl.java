package weather.WeatherRapidAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${rapid.api.key}")
    private String rapidApiKey;

    @Value("${rapid.host.api.key}")
    private String rapidHostApiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<String> getForecastSummaryByLocationName(String locationName) {
        String baseurl = "https://"+rapidHostApiKey+"/rapidapi/forecast/" +locationName+ "/summary/";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", rapidApiKey);
        headers.set("X-RapidAPI-Host", rapidHostApiKey);
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("locationName", locationName);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseurl);
        return restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, entity, String.class);
    }

    @Override
    public ResponseEntity<String> getHourlyForecastByLocationName(String locationName) {
        String baseurl = "https://"+rapidHostApiKey+"/rapidapi/forecast/"+locationName+"/hourly/";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", rapidApiKey);
        headers.set("X-RapidAPI-Host", rapidHostApiKey);
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("locationName", locationName);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseurl);
        return restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(), HttpMethod.GET, entity, String.class);

    }
}