package com.pollux.retrofitdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pollux.retrofitdemo.io.RestClient;
import com.pollux.retrofitdemo.model.Image;
import com.pollux.retrofitdemo.util.Logger;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by SreeKumar on 13/10/15
 */
public class HomeActivity extends AppCompatActivity {


    private static final String API_KEY = "dba3355dc8c8dd0fa6b7a45ce2a44db3";
    private static final String SEARCH_KEY = "android";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Call<Image> imageList = RestClient.build().getImageList(API_KEY, SEARCH_KEY);
        imageList.enqueue(new Callback<Image>() {
            @Override
            public void onResponse(Response<Image> response, Retrofit retrofit) {
                Logger.d("Response received");

            }

            @Override
            public void onFailure(Throwable t) {
                Logger.d("Request failed");
                t.printStackTrace();

            }
        });

    }
}
