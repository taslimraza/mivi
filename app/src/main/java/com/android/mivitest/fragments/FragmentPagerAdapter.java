package com.android.mivitest.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by mobi11 on 31/1/18.
 */

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new UserFragment();
            case 1:
                return new SubscriptionFragment();
            case 2:
                return new ProductsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Account";
            case 1:
                return "Subscription";
            case 2:
                return "Products";
            default:
                return null;
        }
    }
}
