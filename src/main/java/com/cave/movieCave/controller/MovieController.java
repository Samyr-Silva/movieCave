package com.cave.movieCave.controller;

import com.cave.movieCave.model.Movie;
import com.cave.movieCave.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cave")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(path = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovie(@PathVariable int id){
        Movie movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "add", method = RequestMethod.POST)
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.CREATED);
    }
}
