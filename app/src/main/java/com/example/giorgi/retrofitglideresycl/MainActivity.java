package com.example.giorgi.retrofitglideresycl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.giorgi.retrofitglideresycl.connections.RetrofitAPI;
import com.example.giorgi.retrofitglideresycl.models.Repo;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle;
    ImageView ivm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpViews();

        // make Retrofit class
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.omdbapi.com").addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitAPI api = retrofit.create(RetrofitAPI.class);

        // call
        final Call<Repo> repos = api.listRepos("Interstellar","2015", "short", "json");
        repos.enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Call<Repo> call, Response<Repo> response) {
                tvTitle.setText(response.body().getTitle());
                Glide.with(getBaseContext())
                        .load(response.body().getPoster())
                        .into(ivm);
            }

            @Override
            public void onFailure(Call<Repo> call, Throwable t) {
                Log.d("onRespone", "");
            }
        });

    }

    public void setUpViews(){
        tvTitle = (TextView)findViewById(R.id.tvTitle);
        ivm= (ImageView)findViewById(R.id.ivm);
    }
}
