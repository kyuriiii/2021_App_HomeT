package com.example.mobile_filnalproject.ui.onlinegame;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobile_filnalproject.PopupClass;
import com.example.mobile_filnalproject.R;

import java.util.ArrayList;

public class MobileGameAdapter extends BaseAdapter {

    private ArrayList<MobileGameList> listCustom = new ArrayList<MobileGameList>();
    private Context context = null;

    @Override
    public int getCount() { return listCustom.size(); }
    @Override
    public Object getItem(int i) { return listCustom.get(i); }
    @Override
    public long getItemId(int i) { return i; }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        context = viewGroup.getContext();

        if(view ==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_mobilegame, viewGroup, false);
        }

        ImageView img = view.findViewById(R.id.image);
        TextView title = view.findViewById(R.id.title);

        img.setImageDrawable(listCustom.get(i).getImage());
        title.setText(listCustom.get(i).getName());

        return view;
    }

    public void addItem(MobileGameList item){ listCustom.add(item); }
}
