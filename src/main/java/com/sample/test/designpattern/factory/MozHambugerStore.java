package com.sample.test.designpattern.factory;

public class MozHambugerStore extends HamburgerStore {

    @Override
    public HamBurger createHamBurger(String type) {
        if(type.equals("cheese")){
            return new MozCheeseHamburger();
        }else if(type.equals("Veggie")){
            return new MozVeggieBurger();
        }else {
            return null;
        }
    }
}
