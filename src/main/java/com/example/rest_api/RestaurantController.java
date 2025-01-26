package com.example.rest_api;

import com.example.rest_api.exceptions.RestaurantAlreadyExistsException;
import com.example.rest_api.exceptions.RestaurantNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RestaurantController {

    private static final Logger log = LoggerFactory.getLogger(RestaurantController.class);

    private final RestaurantRepository repository;

    RestaurantController(RestaurantRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/restaurant")
    List<Restaurant> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/restaurant")
    Restaurant newRestaurant(@RequestBody Restaurant newRestaurant) {
        return repository.save(newRestaurant);
    }

    // Single item

    @GetMapping("/restaurant/{id}")
    Restaurant one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
    }

    @PutMapping("/restaurant/{id}")
    Restaurant replaceRestaurant(@RequestBody Restaurant newRestaurant, @PathVariable Long id) {

        return repository.findById(id)
                .map(restaurant -> {
                    restaurant.setName(newRestaurant.getName());
                    restaurant.setRatings(newRestaurant.getRatings());
                    return repository.save(restaurant);
                })
                .orElseGet(() -> {
                    return repository.save(newRestaurant);
                });
    }

    @DeleteMapping("/restaurant/{id}")
    void deleteRestaurant(@PathVariable Long id) {
        repository.deleteById(id);
    }


    @PostMapping("/restaurant/{id}/rating/{rating}")
    void addRating(@PathVariable Long id, @PathVariable int rating) {
        log.info("id : {}, rating : {}", id, rating);

        Restaurant restaurant =  repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        Rating newRating = new Rating();
        newRating.setRestaurant(restaurant);
        newRating.setRating(rating);

        restaurant.getRatings().add(newRating);
        repository.save(restaurant);
    }

    @PostMapping("/restaurant/name/{name}")
    void addRestaurant(@PathVariable String name) {
        log.info("new restaurant name : {}", name);

        for (Restaurant restList : repository.findAll()) {
            if (name.equals(restList.getName())){
                throw new RestaurantAlreadyExistsException(name);
            }
        }


        Restaurant restaurant = new Restaurant(name);

        repository.save(restaurant);
    }

    @GetMapping("/restaurant/{id}/rating")
    Double getRestaurantRating(@PathVariable Long id) {
        Restaurant restaurant = repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        return restaurant.getRating();
    }

    @GetMapping("/restaurant/{id}/ratings")
    List<Rating> getRestaurantRatings(@PathVariable Long id) {
        Restaurant restaurant = repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));

        return restaurant.getRatings();
    }
}
