package com.cave.movieCave.service;

import com.cave.movieCave.model.Movie;
import com.cave.movieCave.repository.movieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class movieService {

    @Autowired
    private movieRepository movieRepository;

    public Movie getMovieById(int id){
        return movieRepository.findById(id).get();
    }

    public List<Movie> movieList(){
        return movieRepository.findAll();
    }

    public Movie createMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    public Movie updateMovie(Movie movie){
        Movie newMovie = getMovieById(movie.getId());
        newMovie.setTitle(movie.getTitle());
        newMovie.setImg(movie.getImg());
        newMovie.setScore(movie.getScore());
        return movieRepository.save(newMovie);

    }

    public void deleteMovieById(int id){
        movieRepository.deleteById(id);
    }

}
