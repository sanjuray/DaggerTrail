package com.example.daggertrail;

import android.util.Log;

import javax.inject.Inject;

public class MemoryCard {
//    private int memoryCapacity;
    @Inject
    public MemoryCard() {
    }
//    @Inject
//    public MemoryCard(int memoryCapacity){
//        this.memoryCapacity = memoryCapacity;
//    }

    //For parameterized constructors we can't directly use
    //@Inject Annotation instead
//    MemoryCard providesMemoryCard(){
//        Log.v("Err","Memory card capacity: "+memoryCapacity+"MB");
//        //for passing value we need Module
//        return new MemoryCard();
//    } -> Made the implementation in the MemoryCardModule

//
//    public int getMemoryCapacity() {
//        return memoryCapacity;
//    }
//
//    public void setMemoryCapacity(int memoryCapacity) {
//        this.memoryCapacity = memoryCapacity;
//    }
}
