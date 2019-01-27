package com.mysticwater.myfilms.data.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.util.Calendar;

public class Film implements Comparable<Film> {

    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;

    @SerializedName("release_date")
    private Calendar releaseDate;

    @SerializedName("backdrop_path")
    private String posterPath;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("vote_count")
    private int voteCount;

    public Film(long id, String title, Calendar releaseDate, String posterPath, double voteAverage,
                int voteCount) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.posterPath = posterPath;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public Calendar getReleaseDate() {
        return releaseDate;
    }

    public String getReleaseDateString() {
        DateFormat dateFormat = DateFormat.getDateInstance();
        String result = dateFormat.format(releaseDate.getTime());
        return result;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    @Override
    public int compareTo(@NonNull Film film) {

        return releaseDate.compareTo(film.releaseDate);
    }
}
