package com.example.dagger2.dagger;

import com.example.dagger2.MainActivity;

import dagger.Component;

@Component (modules = {WheelsModule.class, DieselEngineModule.class})
public interface CarComponent {

    //Car getCar(); // implemented by dagger through annotation processing


    void inject(MainActivity mainActivity); // (field injection )needed to inject member variables ref(mainActivity line 17) // need to create an inject for each activity
    //field injection is more for firmware types, the ones that android instantiates likes activates and fragments

}