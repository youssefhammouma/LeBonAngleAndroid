package com.example.lebonanglee.data;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.lebonanglee.R;

import java.sql.Date;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DialogFragment extends androidx.fragment.app.DialogFragment {

    Toolbar toolbar;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.advert_create, null);
        builder.setView(view)
                .setPositiveButton(R.string.createAdvert, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText edtAdvertTitle = (EditText) view.findViewById(R.id.advert_title);
                        EditText edtAdvertAuthor = (EditText) view.findViewById(R.id.advert_author);
                        EditText edtAdvertContent = (EditText) view.findViewById(R.id.advert_content);
                        EditText edtAdvertEmail = (EditText) view.findViewById(R.id.advert_email);
                        EditText edtAdvertPrice = (EditText) view.findViewById(R.id.advert_price);
                        String stringPrice = edtAdvertPrice.getText().toString();
                        int finalPrice = Integer.parseInt(stringPrice);
                        Date date = new Date(Calendar.getInstance().getTime().getTime());

                        Advert advert = new Advert(
                                edtAdvertTitle.getText().toString(),
                                edtAdvertContent.getText().toString(),
                                edtAdvertAuthor.getText().toString(),
                                edtAdvertEmail.getText().toString(),
                                "/api/categories/10",
                                date,
                                null,
                                finalPrice,
                                "draft");

                        Api api = new Retrofit.Builder()
                                .baseUrl(Api.ENDPOINT)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                                .create(Api.class);
                        api.postAdvert(advert).enqueue(new Callback<Advert>() {
                            @Override
                            public void onResponse(Call<Advert> call, Response<Advert> response) {

                                if(!response.isSuccessful()) {
                                    Log.d("erreur", "code: " + response.code());
                                    return;
                                }

                            }

                            @Override
                            public void onFailure(Call<Advert> call, Throwable t) {

                            }
                        });


                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    public void createAdvert() {

    }
}
