package com.mysticwater.myfilms.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import com.mysticwater.myfilms.data.model.Film;
import com.mysticwater.myfilms.data.model.FilmResults;
import com.mysticwater.myfilms.network.TheMovieDbService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsRepository {

    private volatile static FilmsRepository INSTANCE = null;

    private TheMovieDbService theMovieDbService;

    private MediatorLiveData<List<Film>> observableFilms;

    private FilmsRepository() {
        theMovieDbService = TheMovieDbService.Creator.newMovieService();
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

        theMovieDbService.getUpcomingFilms().enqueue(new Callback<FilmResults>() {
            @Override
            public void onResponse(Call<FilmResults> call, Response<FilmResults> response) {
                if (response.isSuccessful()) {
                    FilmResults filmResults = response.body();

                    observableFilms.setValue(filmResults.getResults());
                }
            }

            @Override
            public void onFailure(Call<FilmResults> call, Throwable t) {
                observableFilms.setValue(null);
            }
        });

        return observableFilms;
    }

}
