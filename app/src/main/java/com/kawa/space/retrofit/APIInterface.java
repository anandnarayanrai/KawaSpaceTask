package com.kawa.space.retrofit;


import com.kawa.space.retrofit.responce.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("?inc=gender,name,nat,location,picture,email")
    Call<ApiResponse> doGetUserList(@Query("results") Integer itemCount);
}
