package com.mysticwater.myfilms;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import java.util.List;

public class FilmsViewModel extends AndroidViewModel {

    public final MediatorLiveData<List<Film>> observableFilms;

    public FilmsViewModel(Application application) {
        super(application);

        observableFilms = new MediatorLiveData<>();
        observableFilms.setValue(null);

        FilmsApplication filmsApplication = (FilmsApplication) application;
        LiveData<List<Film>> films = filmsApplication.getFilmsRepository().getFilms();

        observableFilms.addSource(films, observableFilms::setValue);
    }

    public LiveData<List<Film>> getFilms() {
        return observableFilms;
    }
}
