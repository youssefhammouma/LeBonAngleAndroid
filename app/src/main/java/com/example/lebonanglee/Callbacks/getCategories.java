package com.example.lebonanglee.Callbacks;

import android.util.Log;

import com.example.lebonanglee.data.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class getCategories implements Callback<List<Category>> {
    @Override
    public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
        List<Category> categoryList = response.body();


        for (Category category: categoryList
             ) {

            Log.d("MainActivity", category.name);

        }
    }

    @Override
    public void onFailure(Call<List<Category>> call, Throwable t) {

        Log.d("MainActivity", "ERROR");

    }
}
