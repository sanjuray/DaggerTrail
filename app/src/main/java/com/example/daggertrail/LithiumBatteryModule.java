package com.example.daggertrail;

import dagger.Module;
import dagger.Provides;

@Module
public class LithiumBatteryModule {
    @Provides
    Battery provideLithiumBattery(LithiumBattery lithiumBattery){
        lithiumBattery.showType();
        return lithiumBattery;
    }
}
