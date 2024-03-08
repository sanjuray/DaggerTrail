package com.example.daggertrail;

import android.app.Application;

public class App extends Application {
    private static App app;
    private MobileComponent mobileComponent;

    public static App getApp(){
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app =this;
        mobileComponent = DaggerMobileComponent.builder()
                .memoryCardModule(new MemoryCardModule(1024))
                .build();
    }

    public MobileComponent getMobileComponent() {
        return mobileComponent;
    }
}
