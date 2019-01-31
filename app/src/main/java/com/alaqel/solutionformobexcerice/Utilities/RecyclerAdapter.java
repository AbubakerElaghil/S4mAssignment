package com.alaqel.solutionformobexcerice.Utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaqel.solutionformobexcerice.R;

import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by Abubaker on 31/1/2019.
 */

public abstract class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int TOP_RATED_MOVIES = 1;

    private Context context;
    int ItemsCount;

    public RecyclerAdapter(Context context, int ItemsCount) {
        this.context = context;
        this.ItemsCount = ItemsCount;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView;
        RecyclerView.ViewHolder rcv;
        switch (viewType) {
            case TOP_RATED_MOVIES:
                layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
                rcv = new RecyclerViewHolders.MovieViewHolder(layoutView);
                return rcv;
        }

        return null;

    }


    @Override
    public abstract void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position);

    @Override
    public abstract int getItemCount();

    public void updateItemCount(int count) {
        ItemsCount = count;
    }


}

