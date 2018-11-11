package com.mysticwater.myfilms.network;

import java.io.IOException;
import java.util.Locale;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TheMovieDbAuthInterceptor implements Interceptor {

    private static String API_KEY = "api_key";
    private static String LANGUAGE = "language";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url()
                .newBuilder()
                .addQueryParameter(API_KEY, "0201f736e8e671997dfcc9003c16faac")
                .addQueryParameter(LANGUAGE, Locale.getDefault().getLanguage())
                .build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }

}
