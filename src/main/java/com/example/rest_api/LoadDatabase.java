package com.example.rest_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RestaurantRepository repository) {

        return args -> {

            String csvFilePath = "D:\\rest-api\\src\\main\\java\\com\\example\\rest_api\\YelpData\\results.csv";

            Restaurant rootCellar = new Restaurant("Root Cellar");
            Rating rating = new Rating();
            rating.setRestaurant(rootCellar);
            rating.setRating(1);
            rootCellar.getRatings().add(rating);
            repository.save(rootCellar);

            log.info("Preloading " + rootCellar.getName());
            log.info("Preloading " + repository.save(new Restaurant("Alfredos")));

            try {
                List<Restaurant> restaurants = parseCsv(csvFilePath);
                for (Restaurant restaurant : restaurants) {
                    log.info("Preloading " + repository.save(restaurant));
                }
            } catch (Exception e) {
                log.error("Error loading CSV data", e);
            }

        };
    }

    private List<Restaurant> parseCsv(String filePath) throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();

        // Read all lines from the CSV file
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        if (lines.isEmpty()) {
            throw new IllegalArgumentException("CSV file is empty");
        }

        // Extract the header and parse rows
        String header = lines.get(0);
        String[] headers = header.split(",");

        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");

            String name = getFieldValue(headers, values, "\"Name\"");

            String ratingValue = getFieldValue(headers, values, "\"Rating\"").replace("\"", "").trim();
            double yelpRating = 0.0;
            if (!ratingValue.isEmpty()) {
                try {
                    yelpRating = Double.parseDouble(ratingValue);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid rating value: " + ratingValue);
                }
            }


            String price = getFieldValue(headers, values, "\"PriceRange\"");

            Restaurant restaurant = new Restaurant(name);
            restaurant.setPrice(price);

            Rating rating = new Rating();
            rating.setRestaurant(restaurant);
            rating.setRating((int)yelpRating);
            restaurant.getRatings().add(rating);

            restaurants.add(restaurant);
        }

        return restaurants;
    }

    private String getFieldValue(String[] headers, String[] values, String fieldName) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equalsIgnoreCase(fieldName)) {
                return values[i].trim();
            }
        }
        return "";
    }
}

