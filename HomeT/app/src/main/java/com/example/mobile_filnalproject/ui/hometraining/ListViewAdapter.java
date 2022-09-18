package com.example.mobile_filnalproject.ui.hometraining;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobile_filnalproject.PopupClass;
import com.example.mobile_filnalproject.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<ListItem> listCustom = new ArrayList<ListItem>();
    private Context context = null;

    @Override
    public int getCount() {
        return listCustom.size();
    }

    @Override
    public Object getItem(int i) {
        return listCustom.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int pos = i;
        context = viewGroup.getContext();

        if(view ==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_hometraining, viewGroup, false);
        }

        ImageView img = view.findViewById(R.id.image);
        TextView title = view.findViewById(R.id.title);
        TextView youtuber = view.findViewById(R.id.youtuber);
        TextView information = view.findViewById(R.id.information);

        img.setImageDrawable(listCustom.get(i).getImage());

        String titleTxt = listCustom.get(i).getTitle();
        if ( titleTxt.length() > 20 ) titleTxt = titleTxt.substring( 0,18 ) + "...";

        title.setText(titleTxt);
        youtuber.setText(listCustom.get(i).getYoutuber());
        information.setText(listCustom.get(i).getInformation());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            showVideo( listCustom.get(pos).getLink() );
            }
        });

        return view;
    }

    public void showVideo(String link){
        Intent intent = new Intent(context, PopupClass.class);
        intent.putExtra( "code", link );
        context.startActivity(intent);
    }

    public void addItem(ListItem item){ listCustom.add(item); }
}
