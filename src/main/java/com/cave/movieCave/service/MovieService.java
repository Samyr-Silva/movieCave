package com.cave.movieCave.service;

import com.cave.movieCave.model.Movie;
import com.cave.movieCave.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;


    private void validateRating(float rating){
        if(rating < 0 || rating > 10){
            throw new IllegalArgumentException("The rating has to be between 0 to 10!");
        }
    }

    public Movie getMovieById(int id){
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found!"));
    }

    public List<Movie> movieList(){
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie){
        validateRating(movie.getRating());
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie, int id){
        Movie newMovie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found!!"));

        if(movie.getTitle() != null) newMovie.setTitle(movie.getTitle());
        if(movie.getImg() != null) newMovie.setImg(movie.getImg());
        if(movie.getYear() >= 0) newMovie.setYear(movie.getYear());
        if(movie.getCategory() != null) newMovie.setCategory(movie.getCategory());

        validateRating(movie.getRating()); // validate before the update
        newMovie.setRating(movie.getRating());

        return movieRepository.save(newMovie);

    }

    public void deleteMovieById(int id){
        if(!movieRepository.existsById(id)){
            throw new RuntimeException("Movie not found!!");
        }

        movieRepository.deleteById(id);
    }

}
