package com.example.mobile_filnalproject.ui.onlinegame;
import android.graphics.drawable.Drawable;

public class OnlineGameList {
    String name, age, information;
    Drawable image;

    public Drawable getImage() { return image; }
    public void setImage(Drawable image) { this.image = image; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }

    public String getInformation() { return information; }
    public void setInformation(String information) { this.information = information; }
}