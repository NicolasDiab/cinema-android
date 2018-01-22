package fr.polytech.com.cinema.entity;

/**
 * @author GregoirePiat - gregoire.piat.dev@gmail.com
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.Date;
import java.util.Set;

//@Entity
public class Person {
    //@Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    //@NotNull
    private String firstname;
    //@NotNull
    private String lastname;
    private Date deathDate;
    //@NotNull
    private Date birthDate;

    //@OneToMany(mappedBy="person")
    @JsonIgnoreProperties("actors")
    private Set<Actor> movies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Actor> getMovies() {
        return movies;
    }

    public void setMovies(Set<Actor> movies) {
        this.movies = movies;
    }
}
