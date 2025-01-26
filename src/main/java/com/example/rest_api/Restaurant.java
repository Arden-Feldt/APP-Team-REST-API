package com.example.rest_api;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private Price price;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Rating> ratings;


    Restaurant() {}

    Restaurant(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Rating> getRatings() {
        if (ratings == null) {
            ratings = new ArrayList<>();
        }
        return ratings;
    }

    public double getRating() {
        if (ratings == null) {
            ratings = new ArrayList<>();
        }
        int total = 0;
        for (Rating rating : ratings){
            total += rating.getRating();
        }
        return (double) total / ratings.size();
    }

    public String getPrice() {
        if (this.price == null){
            return "";
        }
        return price.toString();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void setPrice(Price price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Restaurant))
            return false;
        Restaurant restaurant = (Restaurant) o;
        return Objects.equals(this.id, restaurant.id) && Objects.equals(this.name, restaurant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.ratings);
    }

    @Override
    public String toString() {
        return "Restaurant{" + "id=" + this.id + ", name='" + this.name + '\'' + ", rating='" + this.ratings + '\'' + '}';
    }

}
