package com.quyplus.tabdemo.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.quyplus.tabdemo.AppFragment;
import com.quyplus.tabdemo.GameFragment;
import com.quyplus.tabdemo.MovieFragment;
/**
 * Created by QUYPM on 7/8/2015.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {
    public TabPagerAdapter(FragmentManager mFragmentManager) {
        super(mFragmentManager);
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return new GameFragment();

            case 1:
                return new MovieFragment();
            case 2:
                return new AppFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
}
