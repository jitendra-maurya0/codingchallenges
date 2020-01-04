package com.sample.test.designpattern.factory;

public abstract class HamBurger {

    public String name;
    public String sauce;
    public String buns;

    public void prepare(){
        System.out.println("preparing - "+name);
        System.out.println("adding sauce - "+sauce);
        System.out.println("adding buns - "+buns);
    }
    public void cook(){
        System.out.println("cooking ..");
    }
    public  void box(){
        System.out.println("boxing ..");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getBuns() {
        return buns;
    }

    public void setBuns(String buns) {
        this.buns = buns;
    }
}
