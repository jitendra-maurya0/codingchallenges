package com.sample.test.designpattern.factory;

public class JamHamBurgerStore extends HamburgerStore {

    @Override
    public HamBurger createHamBurger(String type) {

        if(type.equals("cheese")){
            return new JamaicanCheeseHamburger();
        }else if(type.equals("Veggie")){
            return new JamiconVeggieBurger();
        }else {
            return null;
        }
    }
}
