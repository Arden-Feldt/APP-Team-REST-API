package com.example.rest_api.exceptions;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(Long id) {
        super("Could not find restaurant " + id);
    }
}
