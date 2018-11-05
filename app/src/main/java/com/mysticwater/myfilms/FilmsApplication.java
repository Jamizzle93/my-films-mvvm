package com.mysticwater.myfilms;

import android.app.Application;

public class FilmsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public FilmsRepository getFilmsRepository() {
        return FilmsRepository.getInstance();
    }

}
