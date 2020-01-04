package com.sample.question.designpattern.factory;

public class JamaicanCheeseHamburger extends HamBurger {

    public JamaicanCheeseHamburger() {
        name = "Jamicon Style cheese buger";
        sauce = "Spicy jamicon sauce";
        buns = "cooking dough buns!";
    }

    @Override
    public void prepare() {
        super.prepare();
    }

    @Override
    public void cook() {
        System.out.println("cooking jamican burger");
    }

    @Override
    public void box() {
        super.box();
    }
}
