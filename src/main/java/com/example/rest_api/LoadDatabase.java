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

            // read in web scraped yelp data
            String csvFilePath = "D:\\rest-api\\src\\main\\java\\com\\example\\rest_api\\YelpData\\results.csv";
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
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        // Extract the header and parse rows
        String header = lines.get(0);
        String[] headers = header.split(",");

        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");

            String name = getFieldValue(headers, values, "Name");

            // Parsing Rating
            String ratingValue = getFieldValue(headers, values, "Rating").trim();
            double yelpRating = 0.0;
            if (!ratingValue.isEmpty()) {
                try {
                    yelpRating = Double.parseDouble(ratingValue);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid rating value: " + ratingValue);
                }
            }

            // Parsing PriceRange
            String priceValue = getFieldValue(headers, values, "PriceRange").trim();
            Price price = null;
            if (!priceValue.isEmpty()) {
                try {
                    price = Price.valueOf(priceValue);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid price value: " + priceValue);
                }
            }

            // Create Restaurant object
            Restaurant restaurant = new Restaurant(name);
            restaurant.setPrice(price);

            // Create and add Rating to Restaurant
            Rating rating = new Rating();
            rating.setRestaurant(restaurant);
            rating.setRating((int) yelpRating);
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

