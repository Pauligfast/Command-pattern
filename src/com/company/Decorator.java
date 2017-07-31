package com.company;

/**
 * Created by Paulig on 4/26/2017.
 */
public class Decorator implements Decorable {
    Decorable decorable;


    Decorator(Decorable decorable) {
        this.decorable = decorable;
    }

    @Override
    public void count() {
        decorable.count();
    }
}
