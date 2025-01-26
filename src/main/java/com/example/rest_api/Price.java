package com.example.rest_api;

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
