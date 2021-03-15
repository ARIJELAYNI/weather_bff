package com.example.demo.weather;

import javax.persistence.*;

@Entity
@Table
public class Weather {
    @Id
    @SequenceGenerator(
            name = "weather_sequence",
            sequenceName = "weather_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "weather_sequence"
    )
    private Long id;
    private Long temperature;
    private Long max_temperature;
    private Long min_temperature;

    public Long getId() {
        return id;
    }

    public Weather(Long id, Long temperature, Long max_temperature, Long min_temperature) {
        this.id = id;
        this.temperature = temperature;
        this.max_temperature = max_temperature;
        this.min_temperature = min_temperature;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Weather(Long temperature, Long max_temperature, Long min_temperature) {
        this.temperature = temperature;
        this.max_temperature = max_temperature;
        this.min_temperature = min_temperature;
    }

    public Weather() {
    }

    public Long getTemperature() {
        return temperature;
    }

    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }

    public Long getMax_temperature() {
        return max_temperature;
    }

    public void setMax_temperature(Long max_temperature) {
        this.max_temperature = max_temperature;
    }

    public Long getMin_temperature() {
        return min_temperature;
    }

    public void setMin_temperature(Long min_temperature) {
        this.min_temperature = min_temperature;
    }
}



