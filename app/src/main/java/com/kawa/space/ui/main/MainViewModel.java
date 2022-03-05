package com.kawa.space.ui.main;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kawa.space.retrofit.APIClient;
import com.kawa.space.retrofit.APIInterface;
import com.kawa.space.retrofit.responce.ApiResponse;
import com.kawa.space.retrofit.responce.ResultsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    APIInterface apiInterface;
    MutableLiveData<List<ResultsItem>> volumesResponseLive;

    public MainViewModel() {
        volumesResponseLive = new MutableLiveData<>();
        apiInterface = APIClient.getClient().create(APIInterface.class);
        onGetListResources();
    }

    public MutableLiveData<List<ResultsItem>> getVolumesResponseLive() {
        if (volumesResponseLive == null) {
            volumesResponseLive = new MutableLiveData<>();
        }
        return volumesResponseLive;
    }

    /**
     * GET List Resources
     **/
    public void onGetListResources() {
        Call<ApiResponse> call = apiInterface.doGetUserList(20);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse> call, @NonNull Response<ApiResponse> response) {
                Log.e("TAG", response.code() + "");
                assert response.body() != null;
                volumesResponseLive.postValue(response.body().getResults());
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse> call, Throwable t) {
                call.cancel();
                Log.e("TAG", "onFailure");
            }
        });
    }
}