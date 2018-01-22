package fr.polytech.com.cinema.entity;

/**
 * @author GregoirePiat - gregoire.piat.dev@gmail.com
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

//@Entity
public class Movie {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //@NotNull
    private String title;
    //@NotNull
    private int duration;
    //@NotNull
    private Date releaseDate;
    //@NotNull
    private Double budget;
    //@NotNull
    private Double income;

    //@ManyToOne(targetEntity = Person.class, fetch = FetchType.EAGER)
    //@JoinColumn(name = "director_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("movies")
    private Person director;

    //@ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
    //@JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("movies")
    private Category category;

    //@OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("movie")
    private Set<Actor> actors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
}
