package com.cave.movieCave.controller;

import com.cave.movieCave.model.Movie;
import com.cave.movieCave.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cave")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(path = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovie(@PathVariable int id){
        Movie movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @RequestMapping(path = "list", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> movieList(){
        return new ResponseEntity<>(movieService.movieList(), HttpStatus.OK);
    }

    @RequestMapping(path = "add", method = RequestMethod.POST)
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }

    @RequestMapping(path = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMovie(@PathVariable int id){
        movieService.deleteMovieById(id);
        return new ResponseEntity<>("Movie deleted", HttpStatus.OK);
    }

    @RequestMapping(path = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable int id){
        return new ResponseEntity<>(movieService.updateMovie(movie, id), HttpStatus.OK);
    }
}
