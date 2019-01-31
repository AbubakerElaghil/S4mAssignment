package com.alaqel.solutionformobexcerice.Respository.Server.Response;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("vote_average")
    String vote_average;

  @SerializedName("title")
    String title;

 @SerializedName("overview")
    String overview;

 @SerializedName("release_date")
    String release_date;

    public String getVote_average() {
        return vote_average;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }
}
