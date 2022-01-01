package com.example.mobile_filnalproject.ui.onlinegame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mobile_filnalproject.R;
import com.google.android.material.tabs.TabLayout;

public class OnlineGameFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_onlinegame, container, false);

        ViewPager vp = root.findViewById(R.id.viewPager);
        VPAdapter adapter = new VPAdapter(getFragmentManager());
        vp.setAdapter(adapter);

        TabLayout tab = root.findViewById(R.id.tab);
        tab.setupWithViewPager(vp);

        tab.performClick();

        return root;
    }


}