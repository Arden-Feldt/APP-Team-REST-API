package com.example.rest_api;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "restaurant_rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Connecting ratings to restaurants (like in R or SQL !! )
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    private int rating;

    public Long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setRating(int rating) {

        this.rating = rating;
    }
}
