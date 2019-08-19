package io.tigranes.universe.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.tigranes.universe.Model.NasaJsonReturnModel;

public class NasaImageSearchResponse {

    @SerializedName("collection")
    @Expose()
    private NasaJsonReturnModel collection;

    public NasaJsonReturnModel getItems() {
        return collection;
    }
}
