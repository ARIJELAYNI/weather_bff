package com.example.demo.weather;

import com.example.demo.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface WeatherRepository
        extends JpaRepository<Weather, Long> {

    // SELECT * FROM WEATHER
    @Query(" SELECT w FROM Weather w")
    Weather[] getWeatherHistory();
}
