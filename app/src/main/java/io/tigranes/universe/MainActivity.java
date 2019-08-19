package io.tigranes.universe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import io.tigranes.universe.Adapter.NasaImageSearchRecyclerViewAdapter;
import io.tigranes.universe.Listener.OnNasaSearchItemClickListener;
import io.tigranes.universe.Model.NasaReturnedArray;
import io.tigranes.universe.Retrofit.NasaApi;
import io.tigranes.universe.Retrofit.NasaApiServiceGenerator;
import io.tigranes.universe.Retrofit.NasaImageSearchResponse;
import io.tigranes.universe.Model.NasaJsonReturnModel;
import io.tigranes.universe.ViewModel.MainActivityViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnNasaSearchItemClickListener {

    private RecyclerView nasaImagesRecyclerView;
    private NasaImageSearchRecyclerViewAdapter nasaImageSearchRecyclerViewAdapter;
    private MainActivityViewModel mainActivityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        subscribeObservers();


        nasaImagesRecyclerView = findViewById(R.id.recycler_view);
        nasaImagesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        nasaImageSearchRecyclerViewAdapter = new NasaImageSearchRecyclerViewAdapter(this);
        nasaImagesRecyclerView.setAdapter(nasaImageSearchRecyclerViewAdapter);
    }

    private void subscribeObservers() {

        mainActivityViewModel.getNasaJsonReturnModel().observe(this, new Observer<NasaJsonReturnModel>() {
            @Override
            public void onChanged(NasaJsonReturnModel nasaJsonReturnModel) {
                if (nasaJsonReturnModel != null) {

                    nasaImageSearchRecyclerViewAdapter.setNasaList(nasaJsonReturnModel.getItems());
                }
            }
        });
    }

    public void testNasaApi(View view) {
        mainActivityViewModel.searchByTitle("Galaxy");

    }


//    public void testNasaApi(View view) {
//        final NasaApi recipeApi = NasaApiServiceGenerator.getNasaApi();
//        Call<NasaImageSearchResponse> nasaImageSearchResponseCall = recipeApi.searchImage("galaxy", "image", String.valueOf(1));
//        nasaImageSearchResponseCall.enqueue(new Callback<NasaImageSearchResponse>() {
//
//            @Override
//            public void onResponse(Call<NasaImageSearchResponse> call, Response<NasaImageSearchResponse> response) {
//                if (response.code() == 200) {
//
//                    NasaJsonReturnModel images = response.body().getItems();
//
//                    List<NasaReturnedArray> nasaItemModelsList = response.body().getItems().getItems();
//
//                    for (NasaReturnedArray nasaReturnedArray : nasaItemModelsList) {
//                        Log.d("ABRAKADABRA", nasaReturnedArray.getLinks().get(0).getHref());
//                    }
//
//                } else {
//                    try {
//
//                        Log.d("Not 200", "onResponse: " + response.body());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            // OnFailure return throwable which we can use to print error message.
//            @Override
//            public void onFailure(Call<NasaImageSearchResponse> call, Throwable t) {
//                Log.d("ABRAKADABRA", "ERROR!!!: " + t.toString());
//
//            }
//        });
//
//    }

    @Override
    public void onNasaSearchItemClicked(int position) {

    }
}
