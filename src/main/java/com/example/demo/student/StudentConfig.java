package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student arij = new Student(
                    "Arij",
                    LocalDate.of(1993, Month.AUGUST, 27),
                    "arij.elaini@gmail.com"
            );

            Student mariam = new Student(
                    "Mariam",
                    LocalDate.of(1991, Month.AUGUST, 27),
                    "mariam.elaini@gmail.com"
            );

            repository.saveAll(
                    List.of(mariam, arij)
            );

        };
    }
}
