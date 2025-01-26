package com.example.rest_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class ExceptionAdvice {

    @ExceptionHandler(RestaurantNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String restaurantNotFoundHandler(RestaurantNotFoundException ex) {
        return ex.getMessage();
    }


    // TODO: Check this works!
    @ExceptionHandler(RestaurantAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String resstaurantAlreadyExistsHandler(RestaurantAlreadyExistsException ex) {
        return ex.getMessage();
    }
}
