package com.example.buffet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuffetApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuffetApplication.class, args);
    }
    @Bean
    public CommandLineRunner testPobierania(ProductRepository repository) {
        return args -> repository.findAll().forEach(p -> System.out.println(p.getName()));
    }


}
