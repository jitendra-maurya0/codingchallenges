package com.sample.test.designpattern.factory;

public abstract class HamburgerStore {

    public HamBurger orderHamburger(String type){
        HamBurger burger;
        burger = createHamBurger(type);
        burger.prepare();
        burger.cook();
        burger.box();
        return  burger;
    }

    abstract public HamBurger createHamBurger(String type);


}
