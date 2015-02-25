package com.example.android.wearable.gridviewpager.user;

import android.app.Activity;
import android.content.Context;

import com.example.android.wearable.gridviewpager.R;

import java.util.ArrayList;

/**
 * Created by Vladislavs on 25/02/2015.
 */
public class UserSettings {

    private static UserSettings instance = null;

    private String name;
    private ArrayList<Contact> contacList;
    private boolean available;
    private String userID;

    protected UserSettings() {
        // Exists only to defeat instantiation.
    }
    public static UserSettings getInstance(Context context) {
        if(instance == null) {
            instance = new UserSettings();
            instance.setAvailable(true);
            instance.setContacList(generateContacts(context));
            //todo initialize everything statically
        }
        return instance;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Contact> getContacList() {
        return contacList;
    }

    public void setContacList(ArrayList<Contact> contacList) {
        this.contacList = contacList;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public static ArrayList<Contact> generateContacts(Context context){
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(context.getResources().getDrawable(R.drawable.debug_background_1), "Vlad", "is just a 5 minute walk away", true, "+447845478600", "vlad_00"));
        contacts.add(new Contact(context.getResources().getDrawable(R.drawable.debug_background_2), "Ally", "is just a 12 minute walk away", true, "+447845478600", "ally_00"));
        contacts.add(new Contact(context.getResources().getDrawable(R.drawable.debug_background_3), "Fraser", "is in Edinburgh, United Kingdom", true, "+447845478600", "fraser_00"));
        contacts.add(new Contact(context.getResources().getDrawable(R.drawable.debug_background_4), "David", "is busy", false, "+447845478600", "david_00"));
        return contacts;
    }
}
