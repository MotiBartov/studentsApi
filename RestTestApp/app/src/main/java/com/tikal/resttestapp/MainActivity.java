package com.tikal.resttestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tikal.resttestapp.adapters.StudentsAdapter;
import com.tikal.resttestapp.api.ApiClient;
import com.tikal.resttestapp.api.RetrofitService;
import com.tikal.resttestapp.model.QueryResponse;
import com.tikal.resttestapp.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import rx.Observable;
import rx.Subscription;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Observable<QueryResponse> mSearchObservable;
    private ApiClient mApiClient;
    private Subscription mSubscription;
    private List<Student> mStudents;

    RecyclerView mRvListItems;
    StudentsAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mApiClient = new ApiClient();
        setViews();
    }

    private void setViews() {
        mRvListItems = (RecyclerView) findViewById(R.id.rvItems);
        mRvListItems.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new StudentsAdapter(this);
        mRvListItems.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

       // loadStudent("100");
        getAllStudents();
    }

    private void getAllStudents() {

        RetrofitService apiService = ApiClient.getClient().create(RetrofitService.class);
        Call<QueryResponse> call = apiService.getStudents();
        Log.i(TAG, "loadStudents: uri = " + call.request());

        call.enqueue(new Callback<QueryResponse>() {
            @Override
            public void onResponse(Call<QueryResponse> call, retrofit2.Response<QueryResponse> response) {
                Log.i(TAG, "onResponse: " + response.body().results);
                List<Student> students = response.body().results;
                mAdapter.updateItems(students);

                //Log.i(TAG, "Retrofit onResponse: code: " + response.code() + ", body:" + students.toString());

            }

            @Override
            public void onFailure(Call<QueryResponse> call, Throwable t) {
                Log.e(TAG, "Retrofit onFailure: " + t.getMessage());
            }
        });

    }

    private void loadStudent(String studentId) {
        Log.i(TAG, "getDataWithRetrofit called");

        RetrofitService apiService = ApiClient.getClient().create(RetrofitService.class);
        Call<Student> call = apiService.getStudent(studentId);
        Log.i(TAG, "loadStudents: uri = " + call.request());

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, retrofit2.Response<Student> response) {
                Student student = response.body();

                Log.i(TAG, "Retrofit onResponse: code: " + response.code() + ", body:" + student.toString());

            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Log.e(TAG, "Retrofit onFailure: " + t.getMessage());
            }
        });

    }
}


