package com.company;

/**
 * Created by Paulig on 4/26/2017.
 */
public class RedoDecorator implements Decorable {
    @Override
    public void count() {
      Main.counter++;

    }
}
