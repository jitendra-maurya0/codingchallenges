package com.sample.test.designpattern.factory;

public class MozCheeseHamburger extends HamBurger {

    public MozCheeseHamburger() {
        name = "Moz Style cheese buger";
        sauce = "Moz  sauce";
        buns = "cooking dough buns!";
    }

    @Override
    public void prepare() {
        super.prepare();
    }

    @Override
    public void cook() {
        System.out.println("cooking Mozburgur");
    }

    @Override
    public void box() {
        super.box();
    }
}
