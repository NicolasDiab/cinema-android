package fr.polytech.com.cinema.entity;

/**
 * @author GregoirePiat - gregoire.piat.dev@gmail.com
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import java.util.Set;

//@Entity
public class Category {
    //@Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    //@NotNull
    private String name;
    //@OneToMany(mappedBy="category")
    @JsonIgnoreProperties("category")
    private Set<Movie> movies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}

