package com.cave.movieCave.repository;

import com.cave.movieCave.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
}
