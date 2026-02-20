package com.cave.movieCave.service;

import com.cave.movieCave.model.Favorite;
import com.cave.movieCave.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Spring Framework annotation that tells "I'm the service layer, where we have the business logic"
public class FavoriteService {

    // Proprieties

    @Autowired // inject automatically the propriety
    private FavoriteRepository favoriteRepository;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    public Favorite getFavoriteById(Integer id){
        return favoriteRepository.getReferenceById(id);
    }

    public Favorite addFavorite(Integer movie_id, Integer user_id){
        Favorite favorite = new Favorite();
        favorite.setMovie_id(movieService.getMovieById(movie_id));
        favorite.setUser_id(userService.getUserById(user_id));
        return favoriteRepository.save(favorite);
    }

    public List<Favorite> favoriteList(){
        return favoriteRepository.findAll();
    }
}
