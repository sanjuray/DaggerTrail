package com.example.daggertrail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    @Inject
    Mobile mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Dependency Injection without Dagger
//        Battery battery = new Battery(100);
//        MemoryCard memoryCard = new MemoryCard(1024);
//        Processor processor = new Processor("AMD");
//        CPU cpu = new CPU(processor);
//
//        Mobile mobile = new Mobile(battery,memoryCard,cpu);
//        mobile.printSpecs();

        //Dependency Injection with Dagger
        //1- Annotate all the constructors with @Inject that Dagger uses
        //to construct instances of class. When a new Instance is requested,
        //Dagger will obtain the required parameters values and invoke this constructor.

        //2- Dagger generates codes for DI
        //To us Dagger generated codes for DI, we need to create an Interface annotated with
        //@Component
//        Mobile mobile;
        MobileComponent mobileComponent;
        //1-> create() -> create method is only used when there are no parameters
        //mobileComponent = DaggerMobileComponent.create();

        //2-> For parameterized constructor we use builder
        //mobileComponent= DaggerMobileComponent.builder()

        //3-> When App Activity is in use
        mobile = App.getApp().getMobileComponent().getMobile();
        mobile.ringNow();
        //Modules in Dagger
        //We can use Constructor injection when we own the classes and their constructors
        //In case of third party libraries like Retrofit
        //Firstly, make a module of it with @module and
        //Secondly, add the module to the component
        //Third, Add @Provides in the module class

        //Working with Interfaces
        //We are converting the Battery to an Interface
        //We are having a subclass of battery interface
        //We are making a Module for the subclass and adding it to the Component

        //Working with Parameterized Constructors

        //Created App Activity for:
        /*
         * Custom Application Class:
         * 1. If there are tasks that need to run before the creation of first activity
         * 2. If there are static immutable data such as shared network client objects
         * 3. If there are global objects such as data persistence and crash analytics
         *
         * */

        //Singleton Instance
        Button btn = findViewById(R.id.nxtActivity);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
    }
}