package com.tikal.resttestapp.api;

import android.graphics.Movie;

import com.tikal.resttestapp.model.QueryResponse;
import com.tikal.resttestapp.model.Student;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by motibartov on 01/05/2017.
 */

public interface RetrofitService {

    @GET("student/")
    Call<QueryResponse> getStudents();

    @GET("student/{id}")
    Call<Student> getStudent(@Query("id") String id);


}


