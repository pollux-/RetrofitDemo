package com.pollux.retrofitdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pollux.retrofitdemo.R;
import com.pollux.retrofitdemo.io.RestClient;
import com.pollux.retrofitdemo.model.Image;
import com.pollux.retrofitdemo.util.ImageUtil;
import com.pollux.retrofitdemo.util.Logger;
import com.squareup.picasso.Picasso;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by SreeKumar on 13/10/15
 */
public class HomeActivity extends AppCompatActivity {


    private static final String API_KEY = "462b1fc2f4cd35aba5572a193586d6f0";
    private static final String SEARCH_KEY = "fish";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_activity);



        Call<Image> imageList = RestClient.build().getImageList(API_KEY, SEARCH_KEY);
        imageList.enqueue(new Callback<Image>() {
            @Override
            public void onResponse(Response<Image> response, Retrofit retrofit) {
                Logger.d("Response received");
                Picasso.with(HomeActivity.this).setLoggingEnabled(true);

                ImageUtil.loadImages(findViewById(R.id.first_row), HomeActivity.this, response.body().photos.photo.subList(0, 4));
                ImageUtil.loadImages(findViewById(R.id.second_row), HomeActivity.this, response.body().photos.photo.subList(4,8));
                ImageUtil.loadImages(findViewById(R.id.third_row), HomeActivity.this, response.body().photos.photo.subList(8,12));



            }

            @Override
            public void onFailure(Throwable t) {
                Logger.d("Request failed");
                t.printStackTrace();

            }
        });

    }
}
