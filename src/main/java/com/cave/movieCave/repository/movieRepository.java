package com.cave.movieCave.repository;

import com.cave.movieCave.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface movieRepository extends JpaRepository<Movie, Integer>{
}
