package com.example.demo.weather;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WeatherConfig {

    @Bean
    CommandLineRunner myCommandLineRunner(WeatherRepository repository){
        return args -> {
            Weather data1 = new Weather(
            0L,
            0L,
            0L
            );

            Weather data2 = new Weather(
            2L,
            2L,
            2L
            );

            repository.saveAll(
                    List.of(data1, data2)
            );

        };
    }

}
