package com.example.lebonanglee.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AdvertList {
    @SerializedName("@context")
    public String context;

    @SerializedName("@id")
    public String id;

    @SerializedName("@type")
    public String type;

    @SerializedName("hydra:member")
    public List<Advert> adverts;

    @SerializedName("hydra:totalItems")
    public int total;
}
