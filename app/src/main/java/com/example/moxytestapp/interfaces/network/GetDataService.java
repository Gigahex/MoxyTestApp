package com.example.moxytestapp.interfaces.network;




import com.example.moxytestapp.model.Data.FullData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("JSONSample.json")
    Call<FullData> getFullData();
}
