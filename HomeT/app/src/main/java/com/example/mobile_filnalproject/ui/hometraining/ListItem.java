package com.example.mobile_filnalproject.ui.hometraining;
import android.graphics.drawable.Drawable;

public class ListItem {
    String title, youtuber, information, link;
    Drawable image;

    public Drawable getImage() { return image; }
    public void setImage(Drawable image) { this.image = image; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getYoutuber() { return youtuber; }
    public void setYoutuber(String youtuber) { this.youtuber = youtuber; }

    public String getInformation() { return information; }
    public void setInformation(String information) { this.information = information; }

    public String getLink() { return link; }
    public void setLink( String link ) { this.link = link; }
}