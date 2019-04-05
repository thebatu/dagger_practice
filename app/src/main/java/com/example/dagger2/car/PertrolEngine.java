package com.example.dagger2.car;

import android.util.Log;
import javax.inject.Inject;

public class PertrolEngine implements Engine{

    private static final String TAG = "PertrolEngine";

    @Inject
    public PertrolEngine() {}


    @Override
    public void start() {
        Log.d(TAG, "Petrol engine started");
    }
}
