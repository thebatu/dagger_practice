package com.example.dagger2.dagger;


import com.example.dagger2.car.Driver;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DriverModule.class})
public interface AppComponent {

    Driver getDriver();
}
