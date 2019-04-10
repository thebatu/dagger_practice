package com.example.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dagger2.car.Car;
import com.example.dagger2.dagger.ActivityComponent;
import com.example.dagger2.dagger.AppComponent;
import com.example.dagger2.dagger.DaggerActivityComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    //constructor injection cannt be done in an activity ofcourse coz android system instantiates them.

    @Inject
    Car car1, car2; //field-member injection //cannot be private or final
    //field injection is basically passing the activity to the component and ask it to inject @inject annotated fields



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActivityComponent component = DaggerActivityComponent.create(); //implementation for the interface

        ActivityComponent component = DaggerActivityComponent.builder()
                .horsePower(120)
                .engineCapacity(1400)
                .appComponent(((ExampleApp) getApplication()).getAppComponent())
                .build();

        component.inject(this); // (field injection) inject member variables line 9

        //car = component.getCar(); //no need to instantiate all the classes ourselves dagger takes care of it.

        car1.drive();
        car2.drive();


    }
}
