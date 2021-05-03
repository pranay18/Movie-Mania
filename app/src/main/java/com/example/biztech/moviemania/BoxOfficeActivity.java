package com.example.biztech.moviemania;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class BoxOfficeActivity extends Activity {
    private RecyclerView rvMovies;
    private BoxOfficeMoviesAdapter adapterMovies;
    List<Movie> movieList = new ArrayList<>();
    public static final String MOVIE_DETAIL_KEY = "movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_office);

        rvMovies = (RecyclerView)findViewById(R.id.rvMovies);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvMovies.setLayoutManager(layoutManager);
        adapterMovies = new BoxOfficeMoviesAdapter(movieList);
        rvMovies.setAdapter(adapterMovies);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MoviePageResponseObject> call = apiService.getMovies("08896cfa3b114841d9be6262fc72b9d5");
        call.enqueue(new Callback<MoviePageResponseObject>() {

            @Override
            public void onResponse(Call<MoviePageResponseObject> call, Response<MoviePageResponseObject> response) {
                movieList = response.body().getMovieList();
                Log.d("TAG","Response = "+movieList);
                adapterMovies = new BoxOfficeMoviesAdapter(movieList);
                rvMovies.setAdapter(adapterMovies);
            }

            @Override
            public void onFailure(Call<MoviePageResponseObject> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }


        });

    }

}
