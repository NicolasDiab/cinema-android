package fr.polytech.com.cinema.entity;

/**
 * @author GregoirePiat - gregoire.piat.dev@gmail.com
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import javax.persistence.*;

//@Entity
public class Actor {

    //@EmbeddedId
    private ActorId id;

    //@ManyToOne
    //@JoinColumn(name = "fk_person", insertable = false, updatable = false)
    @JsonIgnoreProperties("movies")
    private Person person;

    //@ManyToOne
    //@JoinColumn(name = "fk_movie", insertable = false, updatable = false)
    @JsonIgnoreProperties("actors")
    private Movie movie;

    //@Column
    private String role;

    public Actor(Person person, Movie movie, String role) {
        // create primary key
        this.id = new ActorId(person.getId(), movie.getId());

        // initialize attributes
        this.person = person;
        this.movie = movie;
        this.role = role;

        // update relationships to assure referential integrity
        person.getMovies().add(this);
        movie.getActors().add(this);
    }

    public Actor() {
    }

    public ActorId getId() {
        return id;
    }

    public void setId(ActorId id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
