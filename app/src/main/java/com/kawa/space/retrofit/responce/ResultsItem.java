package com.kawa.space.retrofit.responce;

import com.google.gson.annotations.SerializedName;

public class ResultsItem {

    @SerializedName("nat")
    private String nat;

    @SerializedName("gender")
    private String gender;

    @SerializedName("name")
    private Name name;

    @SerializedName("location")
    private Location location;

    @SerializedName("email")
    private String email;

    @SerializedName("picture")
    private Picture picture;
    private Boolean isSelected = false;

    public String getNat() {
        return nat;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public Picture getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return
                "ResultsItem{" +
                        "nat = '" + nat + '\'' +
                        ",gender = '" + gender + '\'' +
                        ",name = '" + name + '\'' +
                        ",location = '" + location + '\'' +
                        ",email = '" + email + '\'' +
                        ",picture = '" + picture + '\'' +
                        "}";
    }

    public String getGender() {
        return gender.substring(0, 1).toUpperCase() + gender.substring(1).toLowerCase();
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }
}