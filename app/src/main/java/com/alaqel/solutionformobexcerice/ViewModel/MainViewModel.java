package com.alaqel.solutionformobexcerice.ViewModel;


import android.app.Application;

import com.alaqel.solutionformobexcerice.Respository.Server.Response.MoviesResponse;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends BasicViewModel {

    public MutableLiveData<MoviesResponse> movieRespone = new MutableLiveData<>();


    public MainViewModel(@NonNull Application application) {
        super(application);
    }


    public void getTopRatedMovies(String ApiKey) {

   appRepository.getTopRatedMovies(ApiKey,movieRespone);

    }
}
