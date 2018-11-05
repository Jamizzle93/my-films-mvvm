package com.mysticwater.myfilms;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import java.util.ArrayList;
import java.util.List;

public class FilmsRepository {

    private volatile static FilmsRepository INSTANCE = null;

    private MediatorLiveData<List<Film>> observableFilms;

    private FilmsRepository() {
    }

    public static FilmsRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (FilmsRepository.class) {
                INSTANCE = new FilmsRepository();
            }
        }

        return INSTANCE;
    }

    public LiveData<List<Film>> getFilms() {
        observableFilms = new MediatorLiveData<>();
        loadFilms();

        return observableFilms;
    }

    private void loadFilms() {
        List<Film> films = new ArrayList();
        Film testFilm = new Film(1, "Film Title", "01/01/1970", "https://image.tmdb.org/t/p/w1280/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg", 2.5, 2);
        Film testFilmTwo = new Film(2, "Film Title Two", "02/02/1972", "https://image.tmdb.org/t/p/w1280/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg", 4.25, 20);
        films.add(testFilm);
        films.add(testFilmTwo);

        observableFilms.setValue(films);
    }

}
