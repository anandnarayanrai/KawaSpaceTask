package com.kawa.space.retrofit.responce;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {

    @SerializedName("results")
    private List<ResultsItem> results;

    @SerializedName("info")
    private Info info;

    public List<ResultsItem> getResults() {
        return results;
    }

    public Info getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return
                "ApiResponse{" +
                        "results = '" + results + '\'' +
                        ",info = '" + info + '\'' +
                        "}";
    }
}