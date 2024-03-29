package com.kawa.space.retrofit.responce;

import com.google.gson.annotations.SerializedName;

public class Coordinates {

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return
                "Coordinates{" +
                        "latitude = '" + latitude + '\'' +
                        ",longitude = '" + longitude + '\'' +
                        "}";
    }
}