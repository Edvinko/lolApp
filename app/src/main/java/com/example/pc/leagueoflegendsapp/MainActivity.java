package com.example.pc.leagueoflegendsapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //metoda za stancanje heroja
    public void inputChampInfo(String name, Drawable img) {

        //inflacija layouta u view i pravljenje heroja
        LinearLayout layoutKojiSadrziHeroje = findViewById(R.id.layout_koji_sadrzi_heroje);

        View heroj1 = getLayoutInflater().inflate(R.layout.xml_za_jednog_heroja, null);
        layoutKojiSadrziHeroje.addView(heroj1);

        //ubacivanje imena heroja u layout (TextView)
        TextView champName = (TextView) heroj1.findViewById(R.id.nameChamp);
        champName.setText(name);

        //ubacivanje slike heroja u layout(ImageView)
        ImageView champImage = (ImageView) heroj1.findViewById(R.id.imageChamp);
        champImage.setImageDrawable(img);

    }

    public void onClick(View view) {

        TextView lala = (TextView) findViewById(R.id.nameChamp);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("STRING_I_NEED", lala.getText().toString());

        this.startActivity(intent);

    }




    //click metoda svakog heroja


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

            inputChampInfo("Aatrox", getDrawable(R.drawable.aatrox));
            inputChampInfo("Ahri", getDrawable(R.drawable.ahri));
            inputChampInfo("Akali", getDrawable(R.drawable.akali));
            inputChampInfo("Alistar", getDrawable(R.drawable.alistar));
            inputChampInfo("Amumu", getDrawable(R.drawable.amumu));
            inputChampInfo("Anivia", getDrawable(R.drawable.anivia));
            inputChampInfo("Annie", getDrawable(R.drawable.annie));

    }

}





















//        LinearLayout layoutKojiSadrziHeroje = findViewById(R.id.layout_koji_sadrzi_heroje);
//
//        View heroj2 = getLayoutInflater().inflate(R.layout.xml_za_jednog_heroja, null);
//        View heroj3 = getLayoutInflater().inflate(R.layout.xml_za_jednog_heroja, null);
//        View heroj4 = getLayoutInflater().inflate(R.layout.xml_za_jednog_heroja, null);
//        View heroj5 = getLayoutInflater().inflate(R.layout.xml_za_jednog_heroja, null);
//        View heroj6 = getLayoutInflater().inflate(R.layout.xml_za_jednog_heroja, null);
//        View heroj7 = getLayoutInflater().inflate(R.layout.xml_za_jednog_heroja, null);
//        View heroj8 = getLayoutInflater().inflate(R.layout.xml_za_jednog_heroja, null);
//        View heroj9 = getLayoutInflater().inflate(R.layout.xml_za_jednog_heroja, null);
//        View heroj10 = getLayoutInflater().inflate(R.layout.xml_za_jednog_heroja, null);

//        layoutKojiSadrziHeroje.addView(heroj1);
//        layoutKojiSadrziHeroje.addView(heroj2);
//        layoutKojiSadrziHeroje.addView(heroj3);
//        layoutKojiSadrziHeroje.addView(heroj4);
//        layoutKojiSadrziHeroje.addView(heroj5);
//        layoutKojiSadrziHeroje.addView(heroj6);
//        layoutKojiSadrziHeroje.addView(heroj7);
//        layoutKojiSadrziHeroje.addView(heroj8);
//        layoutKojiSadrziHeroje.addView(heroj9);
//        layoutKojiSadrziHeroje.addView(heroj10);



