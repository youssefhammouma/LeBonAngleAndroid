package com.example.lebonanglee.Callbacks;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.lebonanglee.MainActivity;
import com.example.lebonanglee.R;
import com.example.lebonanglee.data.Advert;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class getAdverts implements Callback<List<Advert>> {

    @Override
    public void onResponse(Call<List<Advert>> call, Response<List<Advert>> response) {
        List<Advert> advertList = response.body();


        for (Advert advert: advertList
             ) {
            Log.d("titre",advert.title);

        }
    }

    @Override
    public void onFailure(Call<List<Advert>> call, Throwable t) {

        Log.d("MainActivity", "ERROR");
    }
}
