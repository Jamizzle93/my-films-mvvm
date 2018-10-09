package com.mysticwater.myfilms;

public class Film {

    private long id;
    private String title;
    private String releaseDate;
    private String posterPath;
    private double voteAverage;
    private int voteCount;

    public Film(long id, String title, String releaseDate, String posterPath, double voteAverage,
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

    public String getReleaseDate() {
        return releaseDate;
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
}
