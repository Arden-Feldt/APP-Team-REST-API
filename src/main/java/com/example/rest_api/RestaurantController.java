package com.example.rest_api;

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
    private final RestaurantRepository repository;

    RestaurantController(RestaurantRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/restaurants")
    List<Restaurant> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/restaurants")
    Restaurant newRestaurant(@RequestBody Restaurant newRestaurant) {
        return repository.save(newRestaurant);
    }

    // Single item

    @GetMapping("/restaurants/{id}")
    Restaurant one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
    }

    @PutMapping("/restaurants/{id}")
    Restaurant replaceEmployee(@RequestBody Restaurant newRestaurant, @PathVariable Long id) {

        return repository.findById(id)
                .map(restaurant -> {
                    restaurant.setName(newRestaurant.getName());
                    restaurant.setRating(newRestaurant.getRating());
                    return repository.save(restaurant);
                })
                .orElseGet(() -> {
                    return repository.save(newRestaurant);
                });
    }

    @DeleteMapping("/restaurants/{id}")
    void deleteRestaurant(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
