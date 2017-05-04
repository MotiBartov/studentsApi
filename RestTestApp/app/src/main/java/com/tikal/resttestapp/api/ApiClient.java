package com.tikal.resttestapp.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by motibartov on 01/05/2017.
 */

public class ApiClient {

    private static final String HOST_NAME = "10.100.10.30:4000";

    private static final String BASE_URL = "http://10.100.10.30:8080/";
    public static final String IMAGES_BASE_URL = "http://10.100.10.30:8080/images/";
    private static Retrofit retrofit = null;




    public static Retrofit getClient() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }
}
