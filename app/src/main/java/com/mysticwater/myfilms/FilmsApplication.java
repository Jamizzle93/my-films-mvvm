package com.mysticwater.myfilms;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.mysticwater.myfilms.data.FilmsRepository;

public class FilmsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);
    }

    public FilmsRepository getFilmsRepository() {
        return FilmsRepository.getInstance();
    }

}
