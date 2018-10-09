package com.mysticwater.myfilms;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {

    private List<Film> films;

    public FilmsAdapter(List<Film> films) {
        this.films = films;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_row_film, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Film film = films.get(i);

        String filmTitle = film.getTitle();
        if (TextUtils.isEmpty(filmTitle)) {
            filmTitle = "";
        }
        viewHolder.title.setText(filmTitle);

        String filmReleaseDate = film.getReleaseDate();
        if (TextUtils.isEmpty(filmReleaseDate)) {
            filmReleaseDate = "";
        }
        viewHolder.releaseDate.setText(filmReleaseDate);

        String filmVoteAverageText = "";
        double filmVoteAverage = film.getVoteAverage();
        if (filmVoteAverage > 0) {
            filmVoteAverageText = String.valueOf(filmVoteAverage);
            viewHolder.ratingBar.setRating((float)filmVoteAverage);
        }
        viewHolder.voteAverage.setText(filmVoteAverageText);

        String filmVoteCountText = "";
        int filmVoteCount = film.getVoteCount();
        if (filmVoteCount > 0) {
            filmVoteCountText = String.valueOf(filmVoteCount);
        }
        viewHolder.voteCount.setText(filmVoteCountText);

        // TODO - Load poster path
    }

    @Override
    public int getItemCount() {
        return films != null ? films.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView poster;
        TextView title;
        TextView voteAverage;
        AppCompatRatingBar ratingBar;
        TextView voteCount;
        TextView releaseDate;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.image_poster);
            title = itemView.findViewById(R.id.text_title);
            voteAverage = itemView.findViewById(R.id.text_vote_average);
            ratingBar = itemView.findViewById(R.id.rating_bar_vote);
            voteCount = itemView.findViewById(R.id.text_vote_count);
            releaseDate = itemView.findViewById(R.id.text_release_date);
        }
    }

}
