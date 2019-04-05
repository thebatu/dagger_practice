package com.example.dagger2.dagger;

import com.example.dagger2.car.Engine;
import com.example.dagger2.car.PertrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
//public class PetrolEngineModule {
public abstract class PetrolEngineModule {

    //better use abstract wherever we can
    // bind method does the same thing as the commented out provides method. but it is shorter
    // and dagger can optimize the method under the hood more than the static provides method.
    //because dagger never create an implemetation of the class or the the below method and it never calls this method, it just instantiats PetrolEngine directly
    // which provides better performance and concise code. So when ever I want to provide an implementation to an interface then I should use a Bind method, bind methods takes a single argument
    // which is the implementation of the interface (ex: interface engine, implementation petrol engine)
    //you cannot use @provides methods in the same module coz dagger does not create an implementation of this abstract class, coz the provider methods needs an instances of the class
    // but we never created an instance of, however, we can use static provides methods.


//    @Provides
//    Engine provideEngine(PertrolEngine engine){
//        return engine;
//    }

    @Binds
    abstract Engine bindEngine(PertrolEngine engine);


}
