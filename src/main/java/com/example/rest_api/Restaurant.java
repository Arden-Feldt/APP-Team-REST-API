package com.example.rest_api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private Double rating;
    private String cuisine;

    Restaurant() {}

    Restaurant(String name, Double rating) {
        this.name = name;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getRating() {
        return rating;
    }

    public String getLocation() {
        return location;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Restaurant))
            return false;
        Restaurant restaurant = (Restaurant) o;
        return Objects.equals(this.id, restaurant.id) && Objects.equals(this.name, restaurant.name);
                // TODO: Check if impl is for instances of rating or instances of restaurant

                // && Objects.equals(this.rating, restaurant.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.rating);
    }

    @Override
    public String toString() {
        // TODO: get return avg of rating
        return "Restaurant{" + "id=" + this.id + ", name='" + this.name + '\'' + ", rating='" + this.rating + '\'' + '}';
    }

}
