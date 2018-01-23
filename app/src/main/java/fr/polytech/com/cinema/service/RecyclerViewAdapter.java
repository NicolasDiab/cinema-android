package fr.polytech.com.cinema.service;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.polytech.com.cinema.entity.Actor;
import fr.polytech.com.cinema.entity.Movie;
import fr.polytech.com.cinema.utils.Utils;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Movie> data_movies = new ArrayList<>();
    private List<Actor> data_actors = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public ImageView image;

        public ViewHolder(View v) {
            super(v);
            text = (TextView) v.findViewById(android.R.id.text1);
            image = (ImageView) v.findViewById(android.R.id.icon1);
        }
    }

    public RecyclerViewAdapter(List<Movie> data_m, List<Actor> data_a) {
        this.data_movies = data_m;
        this.data_actors = data_a;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_selectable_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        if (data_movies != null) {
            Movie movie = data_movies.get(position);

            holder.text.setText(movie.getTitle() + " (" + Utils.getYearFromDate(movie.getReleaseDate()) + ") - "
                    + movie.getDirector().getFirstname() + " " + movie.getDirector().getLastname());
            holder.itemView.setTag(movie.getCategory().getName());
        }
        if (data_actors != null) {
            Actor actor = data_actors.get(position);
            holder.text.setText(actor.getPerson().getLastname() + " " + actor.getPerson().getFirstname());
            holder.itemView.setTag(actor.getRole());
        }
    }

    @Override
    public int getItemCount() {
        if (data_movies != null)
            return data_movies.size();
        if (data_actors != null)
            return data_actors.size();
        return 0;
    }
}