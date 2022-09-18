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
import com.example.mobile_filnalproject.ui.hometraining.ListItem;

import java.util.ArrayList;

public class OnlineGameAdapter extends BaseAdapter {

    private ArrayList<OnlineGameList> listCustom = new ArrayList<OnlineGameList>();
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
            view = inflater.inflate(R.layout.list_onlinegame, viewGroup, false);
        }

        ImageView img = view.findViewById(R.id.image);
        ImageView age = view.findViewById(R.id.ageLimit);
        TextView title = view.findViewById(R.id.title);
        TextView information = view.findViewById(R.id.information);

        img.setImageDrawable(listCustom.get(i).getImage());

        if ( listCustom.get(i).getAge().equals("전체") ) age.setImageResource(R.drawable.age_all);
        else if ( Integer.parseInt( listCustom.get(i).getAge() ) == 8 ) age.setImageResource(R.drawable.age_8);
        else  if ( Integer.parseInt( listCustom.get(i).getAge() ) == 12 ) age.setImageResource(R.drawable.age_12);
        else  if ( Integer.parseInt( listCustom.get(i).getAge() ) == 15 ) age.setImageResource(R.drawable.age_15);
        else  if ( Integer.parseInt( listCustom.get(i).getAge() ) == 19 ) age.setImageResource(R.drawable.age_19);

        title.setText(listCustom.get(i).getName());
        information.setText(listCustom.get(i).getInformation());

        return view;
    }

    public void addItem(OnlineGameList item){ listCustom.add(item); }
}
