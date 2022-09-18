package com.example.mobile_filnalproject.ui.homecook;

import android.graphics.drawable.Drawable;

public class Cook {
    private String name,recipe,material;
    private Drawable image;

    public String getName(){ return this.name; }
    public void setName( String name ) { this.name = name; }

    public Drawable getImage(){ return this.image; }
    public void setImage( Drawable image ) { this.image = image; }

    public String getRecipe(){ return this.recipe; }
    public void setRecipe( String recipe ) { this.recipe = recipe; }

    public String getMaterial(){ return this.material; }
    public void setMaterial( String material ) { this.material = material; }
}
