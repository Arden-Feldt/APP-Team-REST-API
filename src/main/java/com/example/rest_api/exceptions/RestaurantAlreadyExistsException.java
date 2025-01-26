package com.example.rest_api.exceptions;

public class RestaurantAlreadyExistsException extends RuntimeException{
    public RestaurantAlreadyExistsException(String name) {super("Restaurant " + name + " already exists ");
    }
}
