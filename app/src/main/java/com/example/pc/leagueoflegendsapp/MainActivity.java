package com.example.pc.leagueoflegendsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.pc.leagueoflegendsapp.model.Champion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ChampionsAdapter adapter = new ChampionsAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://euw1.api.riotgames.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LolStaticDataApi api = retrofit.create(LolStaticDataApi.class);
        api.getChampions().enqueue(new Callback<ChampionsApiResponse>() {
            @Override
            public void onResponse(Call<ChampionsApiResponse> call, Response<ChampionsApiResponse> response) {
                List<Champion> responseChampions = response.body().toChampions();
                adapter.setChampions(responseChampions);
            }

            @Override
            public void onFailure(Call<ChampionsApiResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Api error occurred.", Toast.LENGTH_LONG).show();
            }
        });

        RecyclerView championsRecyclerView = findViewById(R.id.championsRecyclerView);
        championsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setActivity(this);
        championsRecyclerView.setAdapter(adapter);
    }

}