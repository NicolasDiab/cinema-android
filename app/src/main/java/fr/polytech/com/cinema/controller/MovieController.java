package fr.polytech.com.cinema.controller;


import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import fr.polytech.com.cinema.entity.Movie;
import fr.polytech.com.cinema.service.CinemaApi;
import fr.polytech.com.cinema.service.RecyclerViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieController implements Callback<List<Movie>> {
    private final String API_BASE_URL = "https://PUT URL HERE/";
    private List<Movie> movieList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    public void start(RecyclerView mRecyclerView) {
        this.mRecyclerView = mRecyclerView;

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CinemaApi cinemaApi= retrofit.create(CinemaApi.class);

        Call<List<Movie>> call = cinemaApi.getMovies();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
        if(response.isSuccessful()) {
            List<Movie> movieListInternal = response.body();
            if (movieListInternal != null) {
                movieList = new ArrayList<>();

                for(Movie movie : movieListInternal) {
                    System.out.println(movie.getTitle());
                    movieList.add(movie);
                }

                mAdapter = new RecyclerViewAdapter(movieList);
                mRecyclerView.setAdapter(mAdapter);
            }
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Movie>> call, Throwable t) {
        t.printStackTrace();
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
