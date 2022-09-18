package com.example.mobile_filnalproject.ui.onlinegame;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VPAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext = new ArrayList<String>();

    public VPAdapter(FragmentManager fm){
        super(fm);
        items = new ArrayList<Fragment>();
        items.add(new OnlineFragment());
        items.add(new MobileFragment());

        itext.add("온라인 게임");
        itext.add("모바일 게임");
    }
    @NonNull
    @Override
    public Fragment getItem(int position) { return items.get(position); }
    @Override
    public int getCount() { return items.size(); }
    @NonNull
    @Override
    public CharSequence getPageTitle(int position){ return itext.get(position); }
}
