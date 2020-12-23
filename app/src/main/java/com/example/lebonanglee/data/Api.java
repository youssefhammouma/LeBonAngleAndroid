package com.example.lebonanglee.data;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    public static final String ENDPOINT = "http://192.168.1.10:8000/";

    @Headers("Accept: application/json")
    @GET("api/adverts?state=published")
    Call<List<Advert>> advertList();

    @Headers("Accept: application/json")
    @GET("api/categories")
    Call<List<Category>> categoryList();

    @POST("api/adverts")
    Call<Advert> postAdvert(@Body Advert advert);
}
