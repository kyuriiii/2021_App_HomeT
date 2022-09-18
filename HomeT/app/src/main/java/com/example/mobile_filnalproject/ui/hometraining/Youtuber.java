package com.example.mobile_filnalproject.ui.hometraining;

import android.graphics.drawable.Drawable;

public class Youtuber {
    private String name,url;
    private Drawable image;

    public String getName(){ return this.name; }
    public void setName( String name ) { this.name = name; }

    public Drawable getImage(){ return this.image; }
    public void setImage( Drawable image ) { this.image = image; }

    public String getUrl(){ return this.url; }
    public void setUrl( String url ) { this.url = url; }
}
