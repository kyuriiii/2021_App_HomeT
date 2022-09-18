package com.example.mobile_filnalproject.ui.homecook;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_filnalproject.R;
import com.example.mobile_filnalproject.ui.hometraining.ListItem;
import com.example.mobile_filnalproject.ui.hometraining.Youtuber;

import java.util.ArrayList;

public class CookAdapter extends RecyclerView.Adapter<CookAdapter.ViewHolder> {
    private ArrayList<Cook> items = new ArrayList<>();

    @NonNull
    @Override
    public CookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_homecook_recycle, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CookAdapter.ViewHolder viewHolder, int position) {

        Cook cook = items.get(position);

        viewHolder.imgView.setImageDrawable(cook.getImage());
        viewHolder.txtView.setText(cook.getName());
        viewHolder.recipe = cook.getRecipe();
        viewHolder.material = cook.getMaterial();
        viewHolder.name = cook.getName();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Cook> items) {
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView;
        TextView txtView;
        String material,recipe,name;

        ViewHolder(final View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.imgView);
            txtView = itemView.findViewById(R.id.txtTitle);

            imgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(itemView.getContext())
                            .setTitle( name )
                            .setMessage(
                                    "재료 : " + material + "\n\n" + recipe
                            )
                            .setPositiveButton("확인", null);
                    alertDialog.show();
                }
            });
        }
    }


    public void addItem(Cook item){ items.add(item); }
}
