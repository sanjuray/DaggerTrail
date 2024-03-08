package com.example.daggertrail;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Mobile {
    private Battery battery;
    private MemoryCard memoryCard;
    private CPU cpu;

    //Now, battery is made into an interface and interfaces can't be passed onto constructor
    //instead we use subclasses implementing the battery interface to do so
    @Inject
    public Mobile(Battery battery, MemoryCard memoryCard, CPU cpu) {
        this.battery = battery;
        this.memoryCard = memoryCard;
        this.cpu = cpu;

        //Displaying the creation time of the instance
        SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:MM:ss");
        String time = df.format(Calendar.getInstance().getTime());
        displayTime(time);
    }

    private void displayTime(String time) {
        Log.v("Vroom",time);
    }

    public void ringNow(){
        System.out.println("Ringing...");
    }


//   public void printSpecs(){
//        System.out.println("Battery: "+battery.getBatteryPercentage()+"% Memory: "+memoryCard.getMemoryCapacity()
//        +"MB Processor: "+cpu.getProcessor());
//   }
}
