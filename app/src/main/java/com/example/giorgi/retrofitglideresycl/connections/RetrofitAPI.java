package com.example.giorgi.retrofitglideresycl.connections;

import com.example.giorgi.retrofitglideresycl.models.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by giorgi on 4/5/2016.
 */
public interface RetrofitAPI {

    @GET("/")
    Call<Repo> listRepos(@Query("t") String tt, @Query("y") String yy, @Query("plot") String pp, @Query("r") String rr );
}
