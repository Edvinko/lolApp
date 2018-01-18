package com.example.pc.leagueoflegendsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intent = getIntent();
        String nameChampion = intent.getStringExtra("STRING_I_NEED");

        TextView nameChamp1 = (TextView) findViewById(R.id.nameChamp1);
        nameChamp1.setText(nameChampion);
    }
}
