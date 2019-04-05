package com.example.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dagger2.car.Car;
import com.example.dagger2.dagger.CarComponent;
import com.example.dagger2.dagger.DaggerCarComponent;
import com.example.dagger2.dagger.DieselEngineModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    //constructor injection cannt be done in an activity ofcourse coz android system instantiates them.

    @Inject
    Car car; //field-member injection //cannot be private or final
    //field injection is basically passing the activity to the component and ask it to inject @inject annotated fields

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CarComponent component = DaggerCarComponent.create(); //implementation for the interface
        CarComponent component = DaggerCarComponent.builder()
                .dieselEngineModule( new DieselEngineModule(100))
                .build();



        component.inject(this); // (field injection) inject member variables line 9

        //car = component.getCar(); //no need to instantiate all the classes ourselves dagger takes care of it.

        car.drive();


    }
}
