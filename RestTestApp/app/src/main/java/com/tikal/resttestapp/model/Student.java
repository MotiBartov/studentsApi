package com.tikal.resttestapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by motibartov on 01/05/2017.
 */

public class Student {

    @SerializedName("firstname")
    public String firstname;

    @SerializedName("lastname")
    public String lastname;


    @SerializedName("id")
    public String id;

    @SerializedName("image")
    public String image;


    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
