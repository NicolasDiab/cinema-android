package fr.polytech.com.cinema.service;

/**
 * @author GregoirePiat - gregoire.piat.dev@gmail.com
 */

import java.util.List;

import fr.polytech.com.cinema.entity.Actor;
import fr.polytech.com.cinema.entity.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CinemaApi {

    @GET("people/")
    Call<List<Actor>> getActors();

    @GET("people/{id}")
    Call<Actor> getActorById(@Path("people") String actorId);

    @GET("movies/")
    Call<List<Movie>> getMovies();

    @GET("movie/{id}")
    Call<Movie> getMovieById(@Path("movie") String actorId);
}
