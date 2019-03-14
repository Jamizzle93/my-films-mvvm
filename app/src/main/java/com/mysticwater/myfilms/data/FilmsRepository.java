package com.mysticwater.myfilms.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.text.TextUtils;

import com.mysticwater.myfilms.data.model.Film;
import com.mysticwater.myfilms.data.model.FilmResults;
import com.mysticwater.myfilms.network.TheMovieDbService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

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

        Calendar now = Calendar.getInstance();
        Calendar twoWeeks = Calendar.getInstance();
        twoWeeks.add(Calendar.DATE, 14);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String nowStr = format.format(now.getTime());
        String twoWeeksStr = format.format(twoWeeks.getTime());

        String releaseType = "3|2|1";

        theMovieDbService.getUpcomingFilms(releaseType, nowStr, twoWeeksStr).enqueue(
                new Callback<FilmResults>() {
                    @Override
                    public void onResponse(Call<FilmResults> call, Response<FilmResults> response) {
                        if (response.isSuccessful()) {
                            FilmResults filmResults = response.body();

                            List<Film> filmsToShow = new ArrayList<>();
                            for (Film film : filmResults.getResults()) {
                                if (!TextUtils.isEmpty(film.getPosterPath())) {
                                    filmsToShow.add(film);
                                }
                            }
                            Collections.sort(filmsToShow);
                            observableFilms.setValue(filmsToShow);
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
