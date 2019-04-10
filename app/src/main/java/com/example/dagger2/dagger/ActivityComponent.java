package com.example.dagger2.dagger;

import com.example.dagger2.MainActivity;
import com.example.dagger2.car.Car;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@PerActivity
@Component (dependencies = AppComponent.class, modules = {WheelsModule.class, PetrolEngineModule.class})
public interface ActivityComponent {

    Car getCar(); // implemented by dagger through annotation processing


    void inject(MainActivity mainActivity); // (field injection )needed to inject member variables ref(mainActivity line 17) // need to create an inject for each activity
    //field injection is more for firmware types, the ones that android instantiates likes activates and fragments

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder horsePower(@Named("horse power") int horsePower);

        @BindsInstance
        Builder engineCapacity(@Named("engine capacity") int engineCapacity);

        Builder appComponent (AppComponent component);

        ActivityComponent build();

    }


}