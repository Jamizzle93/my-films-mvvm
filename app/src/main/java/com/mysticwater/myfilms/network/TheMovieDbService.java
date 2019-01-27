package com.mysticwater.myfilms.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysticwater.myfilms.data.model.FilmResults;
import com.mysticwater.myfilms.util.GsonCalendarDeserializer;

import java.util.Calendar;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMovieDbService {
    @GET("discover/movie?")
    Call<FilmResults> getUpcomingFilms(
            @Query("with_release_type") String releaseType,
            @Query("primary_release_date.gte") String startDate,
            @Query("primary_release_date.lte") String endDate
    );

    class Creator {
        public static TheMovieDbService newMovieService() {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new TheMovieDbAuthInterceptor())
                    .build();

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Calendar.class, new GsonCalendarDeserializer())
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();
            return retrofit.create(TheMovieDbService.class);
        }
    }

}
