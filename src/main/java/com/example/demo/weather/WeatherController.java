package com.example.demo.weather;

import com.example.demo.student.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.websocket.DeploymentException;
import java.net.URISyntaxException;


@RestController
@CrossOrigin
@RequestMapping({"api/v1/"})
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping(path="/weather")
    public Weather getWeather() throws JsonProcessingException, DeploymentException, URISyntaxException {
        return weatherService.getWeather();
    }

    @GetMapping(path="/history")
    public Weather[] getWeatherHistory() {
        return weatherService.getWeatherHistory();
    }
    @Scheduled(cron = "0 * * * * *")
    public void registerNewStudent() throws JsonProcessingException, URISyntaxException {
        weatherService.addNewWeatherEntry();
    }


}
