package com.alaqel.solutionformobexcerice.Utilities;

import android.view.View;
import android.widget.TextView;

import com.alaqel.solutionformobexcerice.Events.MovieClickedEvent;
import com.alaqel.solutionformobexcerice.R;
import com.alaqel.solutionformobexcerice.R;

import org.greenrobot.eventbus.EventBus;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Abubaker on 31/1/2019.
 */

public class RecyclerViewHolders {


    public static class MovieViewHolder extends RecyclerView.ViewHolder {



        @BindView(R.id.txt_vote)
        public   TextView txtVoteAverage;


       @BindView(R.id.txt_title)
      public   TextView txtTitle;

        @BindView(R.id.txt_overview)
        public    TextView txtOverview;

        @BindView(R.id.txt_release_date)
        public   TextView txtReleaseDate;

        public MovieViewHolder(View layoutView) {
            super(layoutView);
             ButterKnife.bind(this,layoutView);

            layoutView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventBus.getDefault().post(new MovieClickedEvent(getAdapterPosition()));
                }
            });
        }

    }

}
