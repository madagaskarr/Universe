package io.tigranes.universe.Retrofit;

import java.util.logging.Level;

import io.tigranes.universe.Utility.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NasaApiServiceGenerator {

    public static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();
    private static NasaApi nasaApi = retrofit.create(NasaApi.class);
    public static NasaApi getNasaApi() {
        return nasaApi;
    }
}
