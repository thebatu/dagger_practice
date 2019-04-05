package com.example.dagger2.car;

public class Wheels {
    //we don't own this class so we can't annotate it with @Inject no access to the constructor in this case you can use MODULES!

    private Rims rims;
    private Tires tires;

    public Wheels(Rims rims, Tires tires) {
        this.rims = rims;
        this.tires = tires;
    }
}
