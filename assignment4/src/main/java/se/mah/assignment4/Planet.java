package se.mah.assignment4;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Tim on 2015-04-30.
 */
public class Planet implements Serializable {
    String name;
    Drawable image;
    String description;

    public Planet(String name, Drawable image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }


    public Drawable getImage() {
        return image;
    }
    public void setImage(Drawable image) {
        this.image = image;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSummary() {
        return description;
    }
}
