package com.example.travel;

import java.io.Serializable;

public class Property implements Serializable {
    private int id, image;
    private String headline,  subtitle;

    public Property(int id, int image, String headline, String subtitle ) {
        this.id = id;
        this.image = image;
        this.headline = headline;
        this.subtitle = subtitle;


    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String address) {
        this.headline = headline;
    }


    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }


}

