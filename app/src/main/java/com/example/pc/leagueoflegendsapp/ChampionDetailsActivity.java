package com.example.pc.leagueoflegendsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.pc.leagueoflegendsapp.model.Champion;

public class ChampionDetailsActivity extends AppCompatActivity {

    public static final String KEY_CHAMPION = "Champion";

    private Champion champion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.champion_details_activity);

        Intent intent = getIntent();
        champion = (Champion) intent.getSerializableExtra(KEY_CHAMPION);

        Glide.with(this).load(champion.getSplashUrl()).into((ImageView) findViewById(R.id.imgBackground));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Overview"));
        tabLayout.addTab(tabLayout.newTab().setText("Abilities"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void backClick(View view) {
        finish();
    }

    public Champion getChampion() {
        return champion;
    }

}
