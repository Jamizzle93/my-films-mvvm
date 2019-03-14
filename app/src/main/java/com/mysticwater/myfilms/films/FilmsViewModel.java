package com.mysticwater.myfilms.films;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import com.mysticwater.myfilms.FilmsApplication;
import com.mysticwater.myfilms.data.FilmsRepository;
import com.mysticwater.myfilms.data.model.Film;

import java.util.List;

public class FilmsViewModel extends AndroidViewModel {

    private LiveData<List<Film>> mAllFilms;

    public FilmsViewModel(Application application) {
        super(application);

        FilmsApplication filmsApplication = (FilmsApplication) application;
        FilmsRepository filmsRepository = filmsApplication.getFilmsRepository();
        mAllFilms = filmsRepository.getFilms();
    }

    LiveData<List<Film>> getFilms() {
        return mAllFilms;
    }
}
