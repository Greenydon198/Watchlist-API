package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    MovieService ms = new MovieService();

    //1
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie m){
        return ms.addmovie(m);
    }

    //2
    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director d){
        return ms.addDirector(d);
    }

    //3
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String m,@RequestParam String d){
        return ms.pair(m,d);
    }

    //4
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String m){
        return ms.getMovie(m);
    }

    //5
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String d){
        return ms.getDirector(d);
    }

    //6
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String d){
        return ms.getMovieList(d);
    }

    //7
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        return ms.getallMovies();
    }

    //8
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String d){
        return ms.dltDirector(d);
    }

    //9
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        return ms.deleteAll();
    }
}
