package com.sample.question.designpattern.decorator;

public class IceCreamDecorator implements IceCream {

    IceCream iceCream;

    @Override
    public Double cost() {
        return this.iceCream.cost();
    }

    public IceCreamDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }
}
