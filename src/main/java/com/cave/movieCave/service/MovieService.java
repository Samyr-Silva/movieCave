package com.cave.movieCave.service;

import com.cave.movieCave.model.Movie;
import com.cave.movieCave.repository.movieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private movieRepository movieRepository;

    public Movie getMovieById(int id){
        return movieRepository.findById(id).get();
    }

    public List<Movie> movieList(){
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie){
        movieRepository.save(movie);
        return movie;
    }

    public Movie updateMovie(Movie movie, int id){
        Movie newMovie = movieRepository.findById(id).get();
        newMovie.setTitle(movie.getTitle());
        newMovie.setImg(movie.getImg());
        newMovie.setYear(movie.getYear());
        newMovie.setCategory(movie.getCategory());
        newMovie.setScore(movie.getScore());
        return movieRepository.save(newMovie);

    }

    public void deleteMovieById(int id){
        movieRepository.deleteById(id);
    }

}
