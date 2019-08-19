package io.tigranes.universe.Retrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaApi {

    @GET("search")
    Call<NasaImageSearchResponse> searchImage(@Query("q") String query, @Query("media_type") String mediaType, @Query("page") String page);


}
