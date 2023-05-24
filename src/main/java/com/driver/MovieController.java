package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    MovieService ms = new MovieService();

    //1
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie m){
        return ms.addmovie(m);
    }

    //2
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director d){
        return ms.addDirector(d);
    }

    //3
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String m,@RequestParam String d){
        return ms.pair(m,d);
    }

    //4
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie =  ms.getMovie(name);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    //5
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        return ms.getDirector(name);
    }

    //6
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        return ms.getMovieList(director);
    }

    //7
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return ms.getallMovies();
    }

    //8
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String d){
        return ms.dltDirector(d);
    }

    //9
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        return ms.deleteAll();
    }
}
