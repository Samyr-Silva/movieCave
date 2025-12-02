package com.cave.movieCave.service;

import com.cave.movieCave.model.User;
import com.cave.movieCave.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUserById(int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public User findByEmail(String email){
        if (email == null || email.isBlank()){
            throw new IllegalArgumentException("Email invalid");
        }
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public List<User> userList(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user, int id){
        User newUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!!"));

        if (user.getEmail() != null) newUser.setEmail(user.getEmail());
        if (user.getName() != null) newUser.setName(user.getName());
        if (user.getImage() != null) newUser.setImage(user.getImage());
        if (user.getPassword() != null) newUser.setPassword(user.getPassword());
        if (user.getFavoriteMovies() != null) newUser.setFavoriteMovies(user.getFavoriteMovies());

        return userRepository.save(newUser);
    }

    public String deleteUserById(int id) {
        if(!userRepository.existsById(id)){
            return "User not found!";
        }

        userRepository.deleteById(id);
        return "User deleted successfully!";
    }



}
