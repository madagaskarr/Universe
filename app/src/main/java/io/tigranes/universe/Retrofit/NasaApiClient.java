package io.tigranes.universe.Retrofit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import io.tigranes.universe.Model.NasaJsonReturnModel;
import io.tigranes.universe.Utility.Constants;
import retrofit2.Call;
import retrofit2.Response;

public class NasaApiClient {

    private MutableLiveData<NasaJsonReturnModel> images;
    private RetrieveNasaImageSearchRunnable retrieveNasaImageSearchRunnable;

    private static NasaApiClient instance;
    public static NasaApiClient getInstance() {
        if (instance == null) {
            instance = new NasaApiClient();
        }
        return instance;
    }

    public NasaApiClient() {
        images = new MutableLiveData<>();
    }

    public LiveData<NasaJsonReturnModel> getImages() {
        return images;
    }

    public void searchImage(String query, String mediaType, String page) {

        if (retrieveNasaImageSearchRunnable != null) {
            retrieveNasaImageSearchRunnable = null;
        }

        retrieveNasaImageSearchRunnable = new RetrieveNasaImageSearchRunnable(query, mediaType, page);
        final Future handler = AppExecutors.getInstance().getNetworkInputOutput().submit(retrieveNasaImageSearchRunnable);

        AppExecutors.getInstance().getNetworkInputOutput().schedule(new Runnable() {
            @Override
            public void run() {
                handler.cancel(true);
            }
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);

    }

    private class RetrieveNasaImageSearchRunnable implements Runnable {

        private String query;
        private String mediaType;
        private String page;

        public RetrieveNasaImageSearchRunnable(String query, String mediaType, String page) {
            this.query = query;
            this.mediaType = mediaType;
            this.page = page;
        }

        @Override
        public void run() {
            try {
                Response response = getSearchResult(query, mediaType, page).execute();

                if (response.code() == 200) {
                    NasaJsonReturnModel list = ((NasaImageSearchResponse)response.body()).getItems();

                        images.postValue(list);

                } else {
                    images.postValue(null);
                }
            } catch (IOException e) {
                e.printStackTrace();
                images.postValue(null);
            }

        }

        private Call<NasaImageSearchResponse> getSearchResult(String query, String mediaType, String page) {
            return NasaApiServiceGenerator.getNasaApi().searchImage(query, mediaType, page);
        }

    }


}
