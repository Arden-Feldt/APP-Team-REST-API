package com.example.rest_api;

// Price Enum set up to reflect Yelp pricing system
public enum Price {
    $, $$, $$$;

    @Override
    public String toString() {
        switch(this) {
            case $:
                return "$";
            case $$:
                return "$$";
            case $$$:
                return "$$$";
            default:
                throw new IllegalArgumentException("Unknown price range: " + this);
        }
    }
}
