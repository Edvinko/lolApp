package com.example.pc.leagueoflegendsapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Created by PC on 1/20/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                OverviewFragment overviewFragment = new OverviewFragment();
                return overviewFragment;
            case 1:
                AbilitiesFragment abilitiesFragment = new AbilitiesFragment();
                return abilitiesFragment;
            case 2:
                SkinsFragment skinsFragment = new SkinsFragment();
                return skinsFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
