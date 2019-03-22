package com.example.moxytestapp.model;

import com.example.moxytestapp.model.Data.FullData;
import com.example.moxytestapp.model.Data.Variant;
import com.example.moxytestapp.interfaces.presenter.FetchReceiver;
import com.example.moxytestapp.interfaces.network.GetDataService;
import com.example.moxytestapp.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataModel {
    public static final int OK = 0;
    public static final int ERROR = 1;

    public FullData fullData;
    public void loadDataFromServer(final FetchReceiver receiver) {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<FullData> call = service.getFullData();
        call.enqueue(new Callback<FullData>() {
            @Override
            public void onResponse(Call<FullData> call, Response<FullData> response) {
                saveData(response.body());
                receiver.resultFetch(OK);

            }

            @Override
            public void onFailure(Call<FullData> call, Throwable t) {
                receiver.resultFetch(ERROR);
            }
        });
    }
        void saveData(FullData data) {
            fullData = data;
    }

    public List<Variant> getVariants(){
        return fullData.getData().get(2).getData().getVariants();
    }

    public List<String> getView(){
        return fullData.getView();
    }

    public String getPictureUrl(){
        return fullData.getData().get(1).getData().getUrl();
    }

    public String getHzText(){
        return fullData.getData().get(0).getData().getText();
    }
}
