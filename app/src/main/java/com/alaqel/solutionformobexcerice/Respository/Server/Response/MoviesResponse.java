package com.alaqel.solutionformobexcerice.Respository.Server.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by Abubaker on 31/1/2019.
 */

public class MoviesResponse {


    @SerializedName("status_code")
    int status_code;

    @SerializedName("results")
    List<Movie> movieList;

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public int getStatus_code() {
        return status_code;
    }
}
