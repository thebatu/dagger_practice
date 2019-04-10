package com.example.dagger2.dagger;

import com.example.dagger2.car.Driver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class DriverModule {

    @Singleton
    @Provides
    static Driver provideDriver(){
        return new Driver();
    }
}
