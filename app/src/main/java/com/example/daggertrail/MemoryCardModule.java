package com.example.daggertrail;

import android.util.Log;

import dagger.Module;
import dagger.Provides;

@Module
public class MemoryCardModule {
    private int memoryCapacity;

    public MemoryCardModule(int memoryCapacity){
        this.memoryCapacity = memoryCapacity;
    }

    @Provides
    MemoryCard provideMemoryCard(){
        Log.v("Vroom","The MemoryCard Capacity: "+memoryCapacity);
        return new MemoryCard();
    }

}
