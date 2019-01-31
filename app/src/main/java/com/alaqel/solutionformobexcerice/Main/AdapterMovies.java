package com.alaqel.solutionformobexcerice.Main;

import android.content.Context;

import com.alaqel.solutionformobexcerice.Respository.Server.Response.Movie;
import com.alaqel.solutionformobexcerice.Utilities.RecyclerAdapter;
import com.alaqel.solutionformobexcerice.Utilities.RecyclerViewHolders;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterMovies extends RecyclerAdapter {
    List<Movie> mMoviesList;
    Context context;

    public AdapterMovies(Context context, List<Movie> mMoviesList) {
        super(context, mMoviesList.size());
        this.context = context;
        this.mMoviesList = mMoviesList;
    }

    @Override
    public int getItemViewType(int position) {
        return RecyclerAdapter.TOP_RATED_MOVIES;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        RecyclerViewHolders.MovieViewHolder viewHolder = (RecyclerViewHolders.MovieViewHolder) holder;

        Movie movie = mMoviesList.get(position);

        viewHolder.txtTitle.setText(movie.getTitle());
        viewHolder.txtOverview.setText(movie.getOverview());
        viewHolder.txtReleaseDate.setText(movie.getRelease_date());
        viewHolder.txtVoteAverage.setText(movie.getVote_average());




    }

    @Override
    public int getItemCount() {
        return mMoviesList.size();
    }
}