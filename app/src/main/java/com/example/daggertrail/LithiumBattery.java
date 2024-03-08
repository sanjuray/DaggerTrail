package com.example.daggertrail;

import android.util.Log;

import javax.inject.Inject;

public class LithiumBattery implements Battery{
    //1- Annotate the constructor
    //2- Create module class
    //3- Add the module in the Component
    @Inject
    public LithiumBattery(){
    }
    @Override
    public void showType() {
        Log.v("Vroom","This is a Lithium Battery.");
    }
}
