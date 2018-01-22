package fr.polytech.com.cinema.entity;

/**
 * @author GregoirePiat - gregoire.piat.dev@gmail.com
 */


//import javax.persistence.Column;
//import javax.persistence.Embeddable;
import java.io.Serializable;

//@Embeddable
public class ActorId implements Serializable {

    //@Column(name = "fk_person")
    protected Integer personId;

    //@Column(name = "fk_movie")
    protected Integer movieId;

    public ActorId(Integer personId, Integer movieId) {
        this.personId = personId;
        this.movieId = movieId;
    }

    public ActorId() {
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((personId == null) ? 0 : personId.hashCode());
        result = prime * result
                + ((movieId == null) ? 0 : movieId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        ActorId other = (ActorId) obj;

        if (personId == null) {
            if (other.personId != null)
                return false;
        } else if (!personId.equals(other.personId))
            return false;

        if (movieId == null) {
            if (other.movieId != null)
                return false;
        } else if (!movieId.equals(other.movieId))
            return false;

        return true;
    }
}
