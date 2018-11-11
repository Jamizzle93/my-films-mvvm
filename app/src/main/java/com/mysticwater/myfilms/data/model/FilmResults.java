package com.mysticwater.myfilms.data.model;

import java.util.List;

public class FilmResults {
    private List<Film> results;

    public FilmResults(List<Film> results) {
        this.results = results;
    }

    public List<Film> getResults() {
        return results;
    }
}
