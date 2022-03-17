package com.example.assignmenttops.ListOfButtonsAdapter;

import android.app.Activity;


import androidx.fragment.app.Fragment;

public class Buttons {
    private String Title;
    private Fragment fragment;
    private Class<? extends Activity> activityClass;

    public Buttons(){

    }
    public Buttons(String title, Fragment fragment, Class<? extends Activity> activityClass){
        this.Title = title;
        this.fragment = fragment;
        this.activityClass = activityClass;
    }


    public String getTitle() {
        return Title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public Class<? extends Activity> getActivityClass() {
        return activityClass;
    }







}


