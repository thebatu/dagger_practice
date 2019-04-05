package com.example.dagger2.dagger;

import com.example.dagger2.car.Rims;
import com.example.dagger2.car.Tires;
import com.example.dagger2.car.Wheels;

import dagger.Module;
import dagger.Provides;

//Annotates a class that contributes to the object graph with module.
// if we cant annotated their constructor with @inject (ex: third party libraries or when declaring a dependency as interface) or if we have to do any configuration after instantiating them.
@Module
public class WheelsModule {

    // we can use static whenever the @provide method don't depend on the instance state of the Module.
    //then we can make them static which provides optimisation and performance. coz dagger does not instantiate these methods and calls them directly on the class

    @Provides
    static Rims providerRims(){
        // we cannot annotate Rims constructor but we can call the constructor ourselves.
        return new Rims();
    }



    @Provides
    static Tires providerTires(){
        // we cannot annotate Rims constructor but we can call the constructor ourselves.
        // we can also use @provides method to do any configurations on the object b4 returning it
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }


    // dagger will instantiate tires and rims and pass them to provideWheels
    // in real apps we usually dont call the constructor but we usualy call builder methods like Retofit builder and all can be done inside the method
    @Provides
    static Wheels provideWheels(Tires tires, Rims rims){
        return new Wheels(rims, tires);
    }



}
