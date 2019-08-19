package io.tigranes.universe.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import io.tigranes.universe.Model.NasaJsonReturnModel;
import io.tigranes.universe.Repository.NasaImageSearchRepository;

public class MainActivityViewModel extends ViewModel {

    private NasaImageSearchRepository nasaImageSearchRepository;

    public MainActivityViewModel() {
        nasaImageSearchRepository = NasaImageSearchRepository.getInstance();
    }

    public LiveData<NasaJsonReturnModel> getNasaJsonReturnModel() {
        return nasaImageSearchRepository.getNasaJsonReturnModel();
    }

    public void searchByTitle(String title) {
        nasaImageSearchRepository.searchByTitle(title);
    }
}