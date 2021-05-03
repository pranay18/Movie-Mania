package com.example.biztech.moviemania;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MoviePageResponseObject implements Serializable {

    @SerializedName("page")
    private String page;

    @SerializedName("results")
    private List<Movie> movieList;

    public MoviePageResponseObject(String page, List<Movie> movieList) {
        this.page = page;
        this.movieList = movieList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

}