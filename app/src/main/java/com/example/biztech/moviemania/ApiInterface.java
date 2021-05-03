package com.example.biztech.moviemania;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("discover/movie")
    Call<MoviePageResponseObject> getMovies(@Query(value = "api_key", encoded = false) String auth_token);

}