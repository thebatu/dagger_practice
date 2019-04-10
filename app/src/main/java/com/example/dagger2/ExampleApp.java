package com.example.dagger2;

import android.app.Application;

import com.example.dagger2.dagger.ActivityComponent;
import com.example.dagger2.dagger.AppComponent;
import com.example.dagger2.dagger.DaggerActivityComponent;
import com.example.dagger2.dagger.DaggerAppComponent;

public class ExampleApp extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

       component = DaggerAppComponent.create();

    }


    public AppComponent getAppComponent(){
        return component;
    }
}
