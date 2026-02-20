package com.cave.movieCave.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity  //JPA annotation that tells "this class will be mapped to a table in the DB"
@Table(name = "favorite") // JPA annotation that allow you give a name to the table
@AllArgsConstructor  // Lombok annotation that does the constructor
@NoArgsConstructor
public class Favorite {

    // Proprieties

    @Id // Jakarta Persistence annotation which tells "this is the Primary Key"
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // define how will be generated and how (the generationType part)
    private Integer id;

    @ManyToOne  // define the relationship
    @JoinColumn(name = "movie_id") // this configures the column (gives a name and tell that is the Foreign Key)
    private Movie movie_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    // Gatters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Movie movie_id) {
        this.movie_id = movie_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}
