package com.sample.question.designpattern.decorator;

public class ChocolateIceCream extends IceCreamDecorator {

    public ChocolateIceCream(IceCream iceCream) {

        super(iceCream);
    }

    @Override
    public Double cost() {
        System.out.println("adding chocolate");
        return super.cost()+1.2;
    }
}
