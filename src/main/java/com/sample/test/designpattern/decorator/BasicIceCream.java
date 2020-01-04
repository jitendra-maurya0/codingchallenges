package com.sample.test.designpattern.decorator;

public class BasicIceCream implements IceCream {

    @Override
    public Double cost() {
        return 0.50;
    }

    public BasicIceCream() {
        System.out.println("Created Basic Ice cream");
    }
}
