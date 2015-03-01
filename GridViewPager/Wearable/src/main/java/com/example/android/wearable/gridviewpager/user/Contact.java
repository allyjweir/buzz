package com.example.android.wearable.gridviewpager.user;

import android.graphics.drawable.Drawable;

/**
 * Created by Vladislavs on 25/02/2015.
 */
public class Contact {

    private int picture;//getResources().getDrawable(R.drawable.green_circle)
    private String name;
    private String distance;
    private boolean available;
    private String phonenumber;
    private String userID;

    public Contact(int picture, String name, String distance, boolean available, String phonenumber, String userID) {
        this.picture = picture;
        this.name = name;
        this.distance = distance;
        this.available = available;
        this.phonenumber = phonenumber;
        this.userID = userID;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
