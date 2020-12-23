package com.example.lebonanglee;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lebonanglee.data.Advert;
import com.example.lebonanglee.data.AdvertAdapter;
import com.example.lebonanglee.data.Api;
import com.example.lebonanglee.data.DialogFragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private AdvertAdapter advertAdapter;
    private ArrayList<Advert> adverts = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.advert_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        parseJson();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_1:
                Toast.makeText(this, "Filtre 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_2:
                Toast.makeText(this, "Filtre 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_3:
                createAdvert(item);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    private void parseJson() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();

        Api api = new Retrofit.Builder()
                .baseUrl(Api.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(Api.class);

        api.advertList().enqueue(new Callback<List<Advert>>() {
            @Override
            public void onResponse(Call<List<Advert>> call, Response<List<Advert>> response) {

                if(response.isSuccessful() && response.body() != null)
                {
                    adverts = new ArrayList<>(response.body());
                    advertAdapter = new AdvertAdapter(adverts,MainActivity.this);
                    recyclerView.setAdapter(advertAdapter);

                }

            }

            @Override
            public void onFailure(Call<List<Advert>> call, Throwable t) {

                Log.d("erreur", t.getMessage());

            }
        });

    }

    public void createAdvert(MenuItem item) {

        DialogFragment dialogFragment = new DialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "advert_create");

    }


}