package com.example.pc.leagueoflegendsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        RecyclerView championsRecyclerView = findViewById(R.id.championsRecyclerView);
        championsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ChampionsAdapter adapter = new ChampionsAdapter();
        adapter.setActivity(this);
        championsRecyclerView.setAdapter(adapter);
    }

}