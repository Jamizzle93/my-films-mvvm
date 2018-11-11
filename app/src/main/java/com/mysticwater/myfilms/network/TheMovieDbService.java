package com.mysticwater.myfilms.network;

import com.mysticwater.myfilms.data.model.FilmResults;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface TheMovieDbService {
    @GET("movie/popular")
    Call<FilmResults> getUpcomingFilms();

    class Creator {
        public static TheMovieDbService newMovieService() {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new TheMovieDbAuthInterceptor())
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            return retrofit.create(TheMovieDbService.class);
        }
    }

}
