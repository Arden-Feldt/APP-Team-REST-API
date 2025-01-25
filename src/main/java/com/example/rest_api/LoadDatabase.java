package com.example.rest_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RestaurantRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Restaurant("Root Cellar", 1.0)));
            log.info("Preloading " + repository.save(new Restaurant("Alfredos", 5.0)));
        };
    }
}

