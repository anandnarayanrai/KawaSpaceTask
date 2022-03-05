package com.kawa.space.retrofit.responce;

import com.google.gson.annotations.SerializedName;

public class Timezone {

    @SerializedName("offset")
    private String offset;

    @SerializedName("description")
    private String description;

    public String getOffset() {
        return offset;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return
                "Timezone{" +
                        "offset = '" + offset + '\'' +
                        ",description = '" + description + '\'' +
                        "}";
    }

    public String getTimeZone() {
        return getOffset() + ", " + getDescription();
    }

}