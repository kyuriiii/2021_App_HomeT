package com.example.mobile_filnalproject.ui.hometraining;

import android.content.Context;
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

import java.util.ArrayList;

public class YoutuberAdapter extends RecyclerView.Adapter<YoutuberAdapter.ViewHolder> {
    private ArrayList<Youtuber> items = new ArrayList<>();

    @NonNull
    @Override
    public YoutuberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_hometraining_recycle, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull YoutuberAdapter.ViewHolder viewHolder, int position) {

        Youtuber youtuber = items.get(position);

        viewHolder.imgView.setImageDrawable(youtuber.getImage());
        viewHolder.txtView.setText(youtuber.getName());
        viewHolder.url = youtuber.getUrl();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Youtuber> items) {
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView;
        TextView txtView;
        String url;

        ViewHolder(View itemView) {
            super(itemView);

            imgView = itemView.findViewById(R.id.imgView);
            txtView = itemView.findViewById(R.id.name);
            final Context context = itemView.getContext();

            imgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse( url ));
                    context.startActivity(intent);
                }
            });
        }
    }

    public void addItem(Drawable image, String name, String Url){
        Youtuber item = new Youtuber();

        item.setImage(image);
        item.setName(name);
        item.setUrl(Url);

        items.add(item);
    }
}
