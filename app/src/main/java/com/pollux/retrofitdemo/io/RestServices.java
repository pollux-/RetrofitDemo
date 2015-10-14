package com.pollux.retrofitdemo.io;

import com.pollux.retrofitdemo.model.Image;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by SreeKumar on 13/10/15
 */
public interface RestServices {

    @GET("/?method=flickr.photos.search&format=json&nojsoncallback=1")
    Call<Image> getImageList(@Query("api_key") String apiKey, @Query("text") String searchKey);

}
