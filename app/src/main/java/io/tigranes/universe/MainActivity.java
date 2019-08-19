package io.tigranes.universe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import io.tigranes.universe.Model.NasaReturnedArray;
import io.tigranes.universe.Retrofit.NasaApi;
import io.tigranes.universe.Retrofit.NasaApiServiceGenerator;
import io.tigranes.universe.Retrofit.NasaImageSearchResponse;
import io.tigranes.universe.Model.NasaJsonReturnModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    int starting = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testNasaApi(View view) {
        final NasaApi recipeApi = NasaApiServiceGenerator.getNasaApi();
        Call<NasaImageSearchResponse> nasaImageSearchResponseCall = recipeApi.searchImage("galaxy", "image", String.valueOf(starting));
        nasaImageSearchResponseCall.enqueue(new Callback<NasaImageSearchResponse>() {

            @Override
            public void onResponse(Call<NasaImageSearchResponse> call, Response<NasaImageSearchResponse> response) {
                if (response.code() == 200) {

//                    Log.d("ABRAKADABRA", "" + response.body().getItems().getItems().get(0).getData().get(0).getTitle());
//                    Log.d("ABRAKADABRA", "" + response.raw().request().url());
                    NasaJsonReturnModel images = response.body().getItems();

                    List<NasaReturnedArray> nasaItemModelsList = response.body().getItems().getItems();

                    for (NasaReturnedArray nasaReturnedArray : nasaItemModelsList) {
                        Log.d("ABRAKADABRA", nasaReturnedArray.getLinks().get(0).getHref());
                    }

//                    Log.d("TIGRAN", images.get(0).getLinks().getHref());

                } else {
                    try {

                        Log.d("Not 200", "onResponse: " + response.body());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            // OnFailure return throwable which we can use to print error message.
            @Override
            public void onFailure(Call<NasaImageSearchResponse> call, Throwable t) {
                Log.d("ABRAKADABRA", "ERROR!!!: " + t.toString());

            }
        });

        starting++;
    }
}
