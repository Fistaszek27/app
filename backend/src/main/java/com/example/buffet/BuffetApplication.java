package com.example.buffet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BuffetApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuffetApplication.class, args);
    }

    @Bean
    public CommandLineRunner testPobierania(NameRepository repository) {
        return args -> repository.findAll().forEach(n -> System.out.println(n.getName()));
    }
}
