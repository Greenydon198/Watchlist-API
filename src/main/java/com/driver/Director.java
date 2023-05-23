package com.driver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Director {
    private String name;
    private int numberOfMovies;
    private double imdbRating;

    public Director(String name, int numberOfMovies, double imdbRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }

    public Director() {
    }
}
