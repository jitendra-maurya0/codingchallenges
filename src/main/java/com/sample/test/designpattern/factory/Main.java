package com.sample.test.designpattern.factory;

public class Main {

    public static void main(String[] args) {
        HamburgerStore mozabicanBurgerStore = new MozHambugerStore();
        HamburgerStore jamHamBurgerStore = new JamHamBurgerStore();

        HamBurger hamBurger = mozabicanBurgerStore.orderHamburger("cheese");

        System.out.println("paulo ordered :"+hamBurger.getName());


    }
}
