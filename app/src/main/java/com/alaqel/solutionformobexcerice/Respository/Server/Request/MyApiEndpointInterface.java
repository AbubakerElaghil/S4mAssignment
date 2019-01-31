package com.alaqel.solutionformobexcerice.Respository.Server.Request;

import com.alaqel.solutionformobexcerice.Respository.Server.Response.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Abubaker on 31/1/2019.
 */

public interface MyApiEndpointInterface {


    @GET("3/movie/top_rated?language=en-US&page=1")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String api_key);



   // https://api.themoviedb.org/3/movie/top_rated?language=en-US&page=1&api_key=6da670c901f0c8c295506d479bfc5615
}

