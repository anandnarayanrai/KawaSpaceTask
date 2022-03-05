package com.kawa.space.retrofit.responce;

import com.google.gson.annotations.SerializedName;

public class Name {

    @SerializedName("last")
    private String last;

    @SerializedName("title")
    private String title;

    @SerializedName("first")
    private String first;

    public String getLast() {
        return last;
    }

    public String getTitle() {
        return title;
    }

    public String getFirst() {
        return first;
    }

    @Override
    public String toString() {
        return
                "Name{" +
                        "last = '" + last + '\'' +
                        ",title = '" + title + '\'' +
                        ",first = '" + first + '\'' +
                        "}";
    }

    public String getFullName() {
        return getTitle() + ". " + getFirst() + " " + getLast();
    }
}