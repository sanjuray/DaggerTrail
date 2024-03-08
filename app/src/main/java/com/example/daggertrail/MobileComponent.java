package com.example.daggertrail;

import dagger.Component;

@Component(modules = {/*BatteryModule.class,*/ LithiumBatteryModule.class, MemoryCardModule.class})
public interface MobileComponent {
    Mobile getMobile();
}
