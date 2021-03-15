package com.example.demo.weather;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URISyntaxException;
import java.util.Optional;


@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;

    private static final String api_url = "http://api.openweathermap.org/data/2.5/weather?q=Darmstadt&appid=e4085bee93b8d532076aac647f88cddc";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper;

    @Autowired
    public WeatherService(ObjectMapper objectMapper, WeatherRepository weatherRepository) {
        this.objectMapper = objectMapper;
        this.weatherRepository = weatherRepository;
    }

    public Weather getWeather() throws JsonProcessingException, URISyntaxException {
        ResponseEntity<String> result = restTemplate.getForEntity(api_url, String.class);
        return convert(result);
    }

    private Weather convert(ResponseEntity<String> response ) throws JsonProcessingException {
        JsonNode root = objectMapper.readTree(response.getBody());
        return new Weather(
            Long.valueOf(root.path("main").path("temp").asLong()),
            Long.valueOf(root.path("main").path("temp_min").asLong()),
            Long.valueOf(root.path("main").path("temp_max").asLong())
        );
    }

    public void addNewWeatherEntry() throws JsonProcessingException, URISyntaxException {
        Weather currentWeather = getWeather();
        weatherRepository.save(currentWeather);

        System.out.println(currentWeather);

    }

    public Weather[] getWeatherHistory() {
        return weatherRepository.getWeatherHistory();
    }
}
