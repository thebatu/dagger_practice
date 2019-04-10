package com.example.dagger2.car;

import android.util.Log;

import com.example.dagger2.dagger.PerActivity;

import javax.inject.Inject; // JSR 330

@PerActivity
public class Car {
    private static final String TAG = "Car";

    private Driver driver;
    private Wheels wheels;
    private Engine engine;

    // if we dont have an @inject annotaed constructor we have to trigger field and method injection manually by calling inject on the component

    @Inject // constructor injection, can be done on a single constructor only, dagger can create instances of the car and automatically provide the arguments
    public Car(Engine engine, Wheels wheels, Driver driver) {
        this.driver = driver;
        this.engine = engine;
        this.wheels = wheels;
    }


    // method injection
    // if you have to pass the injected object itself to the dependency, coz if u execute line 23 in the constructor, you will be passing a reference to an object that is not yet instantiated
    // coz the constructor has not finished yet, avoid this and pass it after the constructor has finished, and it can be done like in the below method.
    // only good case use of method injection is when u have to pass an instance of the object itself to the dependency like below.
    @Inject
    public void enableRemote(Remote remote){
        //pass the car instance to remote,
        remote.setListener(this);
    }

    public void drive() {
        Log.d(TAG,  driver + " drives..." + this);
    }
}
