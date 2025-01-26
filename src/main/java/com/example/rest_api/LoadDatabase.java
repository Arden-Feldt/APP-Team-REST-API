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
            Restaurant rootCellar = new Restaurant("Root Cellar");
            Rating rating = new Rating();
            rating.setRestaurant(rootCellar);
            rating.setRating(1);
            rootCellar.getRatings().add(rating);
            repository.save(rootCellar);

            log.info("Preloading " + rootCellar.getName());
            log.info("Preloading " + repository.save(new Restaurant("Alfredos")));
        };
    }
}

