package com.alaqel.solutionformobexcerice.ViewModel;

import android.app.Application;
import android.content.Context;

import com.alaqel.solutionformobexcerice.Respository.WebServiceResp;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class BasicViewModel extends AndroidViewModel {

    public WebServiceResp appRepository;
    public  Executor executor = Executors.newSingleThreadExecutor();


    Context context;

    public BasicViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        appRepository =   WebServiceResp.getInstance(application.getApplicationContext());
     }



}
