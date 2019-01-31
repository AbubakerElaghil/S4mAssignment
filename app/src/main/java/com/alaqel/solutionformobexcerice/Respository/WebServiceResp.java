package com.alaqel.solutionformobexcerice.Respository;

import android.content.Context;
import android.util.Log;

import com.alaqel.solutionformobexcerice.Respository.Server.Request.MyApiEndpointInterface;
import com.alaqel.solutionformobexcerice.Respository.Server.Response.MoviesResponse;

import java.util.concurrent.TimeUnit;

import androidx.lifecycle.MutableLiveData;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServiceResp {


    private MyApiEndpointInterface apiService;
    public static String Server_URL = "https://api.themoviedb.org/";


    public static WebServiceResp getInstance(Context context) {
        return new WebServiceResp( );
    }

    public WebServiceResp() {
        initRetrofit();
    }

    private void initRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(120, TimeUnit.SECONDS).readTimeout(120, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build();

        try {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Server_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiService = retrofit.create(MyApiEndpointInterface.class);

        } catch (Exception e) {
            Log.e("EXCEPTION", e.getMessage());
        }
    }


    public void getTopRatedMovies(String ApiKey , MutableLiveData<MoviesResponse> data) {
        apiService.getTopRatedMovies(ApiKey).enqueue(new ResponseCallBacks(data));

    }


    private class ResponseCallBacks implements Callback<MoviesResponse> {


        MutableLiveData<MoviesResponse> data;

        public ResponseCallBacks(MutableLiveData<MoviesResponse> data) {
            this.data = data;
        }


        @Override
        public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
            try {
                Log.e("RESPONSE", response.message());

                HandleResponse(response.body());
            } catch (Exception e) {
                Log.e("EXception", e.getMessage());
                HandleResponse(null);
            }
        }

        @Override
        public void onFailure(Call<MoviesResponse> call, Throwable t) {
            HandleResponse(null);
        }


        private void HandleResponse(MoviesResponse responseObject) {

            data.setValue(responseObject);

        }
    }


}
