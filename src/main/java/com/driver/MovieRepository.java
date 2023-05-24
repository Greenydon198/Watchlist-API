package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieRepository {
    HashMap<String,Movie> Movies;
    HashMap<String,Director> Directors;
    HashMap<String,List<String>> D_M;

    public MovieRepository(){
        Movies = new HashMap<>();
        Directors = new HashMap<>();
        D_M = new HashMap<>();
    }


    public ResponseEntity<String> addmovie(Movie m) {
        Movies.put(m.getName(),m);
        return new ResponseEntity<>("Movie Added Successfully", HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> addDirector(Director d) {
        Directors.put(d.getName(),d);
        return new ResponseEntity<>("Director Added Successfully", HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> pair(String m, String d) {
        if(Movies.containsKey(m) && Directors.containsKey(d)){
            List<String> list = D_M.getOrDefault(d,new ArrayList<>());
            list.add(m);
            D_M.put(d,list);
        }
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public Movie getMovie(String m) {
        return Movies.get(m);
    }

    public ResponseEntity<Director> getDirector(String d) {
        return new ResponseEntity<>(Directors.get(d),HttpStatus.OK);
    }

    public ResponseEntity<List<String>> getMovieList(String d) {
//        System.out.println(D_M);
        return new ResponseEntity<>(D_M.get(d),HttpStatus.OK);
    }

    public ResponseEntity<List<String>> getallMovies() {
        return new ResponseEntity<>(new ArrayList<>(Movies.keySet()),HttpStatus.OK);
    }

    public ResponseEntity<String> dltDirector(String d) {
        for(String m:D_M.get(d)){
            if(Movies.containsKey(m))
                Movies.remove(m);
        }
        D_M.remove(d);
        return new ResponseEntity<>("Deleted All Directors & their Movies",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteAll() {

        for(String d:D_M.keySet()){
            dltDirector(d);
        }
        D_M = new HashMap<>();
        Directors = new HashMap<>();
        return new ResponseEntity<>("Deleted All Directors & their Movies",HttpStatus.OK);
    }
}
