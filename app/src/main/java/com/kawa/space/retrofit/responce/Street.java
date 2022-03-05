package com.kawa.space.retrofit.responce;

import com.google.gson.annotations.SerializedName;

public class Street {

    @SerializedName("number")
    private int number;

    @SerializedName("name")
    private String name;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "Street{" +
                        "number = '" + number + '\'' +
                        ",name = '" + name + '\'' +
                        "}";
    }
}