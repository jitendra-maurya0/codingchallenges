package com.sample.test.designpattern.decorator;

public class Main {

    public static void main(String[] args) {

        IceCream basicIceCream = new BasicIceCream();

        System.out.println("basic ice cream cost: "+basicIceCream.cost());

        //add vanilla
        IceCream vanilla = new VanillaIceCream(basicIceCream);

        System.out.println("vanilla ice cream cost : "+vanilla.cost());

    }
}
