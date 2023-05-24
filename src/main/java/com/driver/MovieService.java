package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class MovieService {

    MovieRepository mr = new MovieRepository();

    public ResponseEntity<String> addmovie(Movie m) {
        return mr.addmovie(m);
    }

    public ResponseEntity<String> addDirector(Director d) {
        return mr.addDirector(d);
    }

    public ResponseEntity<String> pair(String m, String d) {
        return mr.pair(m,d);
    }

    public Movie getMovie(String m) {
        return mr.getMovie(m);
    }

    public ResponseEntity<Director> getDirector(String d) {
        return mr.getDirector(d);
    }

    public ResponseEntity<List<String>> getMovieList(String d) {
        return mr.getMovieList(d);
    }

    public ResponseEntity<List<Movie>> getallMovies() {
        return mr.getallMovies();
    }

    public ResponseEntity<String> dltDirector(String d) {
        return mr.dltDirector(d);
    }

    public ResponseEntity<String> deleteAll() {
        return mr.deleteAll();
    }
}
