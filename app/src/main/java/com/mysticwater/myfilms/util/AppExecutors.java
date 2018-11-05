package com.mysticwater.myfilms.util;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Adapted from the AppExecutors class in the BasicSample project
 * https://github.com/googlesamples/android-architecture-components/tree/master/BasicSample
 */
public class AppExecutors {

    private final Executor diskExecutor;

    private final Executor networkExecutor;

    private final Executor mainThreadExecutor;

    private AppExecutors(Executor diskExecutor, Executor networkExecutor, Executor
            mainThreadExecutor) {
        this.diskExecutor = diskExecutor;
        this.networkExecutor = networkExecutor;
        this.mainThreadExecutor = mainThreadExecutor;
    }

    public AppExecutors() {
        this(Executors.newSingleThreadExecutor(),
                Executors.newFixedThreadPool(3),
                new MainThreadExecutor());
    }

    public Executor getDiskExecutor() {
        return diskExecutor;
    }

    public Executor getNetworkExecutor() {
        return networkExecutor;
    }

    public Executor getMainThreadExecutor() {
        return mainThreadExecutor;
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }

}
