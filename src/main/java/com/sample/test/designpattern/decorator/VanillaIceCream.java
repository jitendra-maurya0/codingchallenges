package com.sample.test.designpattern.decorator;

public class VanillaIceCream extends IceCreamDecorator {
    @Override
    public Double cost() {
        System.out.println("adding vanilla ice cream");
        return super.cost()+1.0;
    }

    public VanillaIceCream(IceCream iceCream) {
        super(iceCream);
    }
}
