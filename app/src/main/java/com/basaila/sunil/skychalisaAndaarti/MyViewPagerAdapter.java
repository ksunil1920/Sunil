package com.basaila.sunil.skychalisaAndaarti;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunil on 11/19/2017.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> myFragment = new ArrayList<>();
    private List<String> myTitle = new ArrayList<>();

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void AddFragmentPage(Fragment Frag, String Title) {
        myFragment.add(Frag);
        myTitle.add(Title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return myTitle.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return myFragment.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
