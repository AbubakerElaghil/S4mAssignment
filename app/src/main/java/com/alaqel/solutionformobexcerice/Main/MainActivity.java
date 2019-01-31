package com.alaqel.solutionformobexcerice.Main;

import android.os.Bundle;
import android.widget.Toast;

import com.alaqel.solutionformobexcerice.Events.MovieClickedEvent;
import com.alaqel.solutionformobexcerice.R;
import com.alaqel.solutionformobexcerice.Respository.Server.Response.Movie;
import com.alaqel.solutionformobexcerice.Respository.Server.Response.MoviesResponse;
import com.alaqel.solutionformobexcerice.Utilities.BaseActivity;
import com.alaqel.solutionformobexcerice.Utilities.ConnectionDetector;
import com.alaqel.solutionformobexcerice.ViewModel.MainViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rec_movies)
    RecyclerView recMovies;

    MainViewModel mainViewModel;

    AdapterMovies adapterMovies;

    List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
        initViewModel();
        initViews();
        getTopRatedMovies();
    }


    private void initViewModel() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

    }

    private void initViews() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        recMovies.setLayoutManager(linearLayoutManager);

        adapterMovies = new AdapterMovies(context, movieList);
        recMovies.setAdapter(adapterMovies);

    }

    private void getTopRatedMovies() {

        if (ConnectionDetector.isConnectingToInternet(context)) {
            mainViewModel.movieRespone.observe(this, new Observer<MoviesResponse>() {
                @Override
                public void onChanged(MoviesResponse moviesResponse) {
                    HideProgress();
                    if (moviesResponse != null) {

                        if (moviesResponse.getStatus_code() == 7) {
                            Toast.makeText(context, "You must be granted a valid key", Toast.LENGTH_SHORT).show();
                        } else {
                            if (moviesResponse.getMovieList() != null && moviesResponse.getMovieList().size() > 0) {
                                movieList.addAll(moviesResponse.getMovieList());
                                adapterMovies.notifyDataSetChanged();
                            }
                        }
                    } else {
                        Toast.makeText(context, "You must be granted a valid key", Toast.LENGTH_SHORT).show();

                    }
                }
            });
            ShowProgress("Getting Top Rate Movies", "Loading...", context);
            mainViewModel.getTopRatedMovies("6da670c901f0c8c295506d479bfc5615");

        } else {
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    @Subscribe
    public void movieClickedEvent(MovieClickedEvent event) {

        Toast.makeText(context, movieList.get(event.getAdatperPostion()).getTitle(), Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
