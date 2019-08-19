package io.tigranes.universe.Repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import io.tigranes.universe.Model.NasaJsonReturnModel;
import io.tigranes.universe.Model.NasaReturnedArray;
import io.tigranes.universe.Retrofit.NasaApiClient;

public class NasaImageSearchRepository {


    NasaApiClient nasaApiClient;

    private static NasaImageSearchRepository instance;
    public static NasaImageSearchRepository getInstance() {
        if (instance == null) {
            instance = new NasaImageSearchRepository();
        }
        return instance;
    }

    public NasaImageSearchRepository() {
        nasaApiClient = NasaApiClient.getInstance();
    }

    public LiveData<NasaJsonReturnModel> getNasaJsonReturnModel() {
        return nasaApiClient.getImages();
    }

    public void searchByTitle(String title) {
        nasaApiClient.searchImage(title, "image", String.valueOf(1));
    }

}
