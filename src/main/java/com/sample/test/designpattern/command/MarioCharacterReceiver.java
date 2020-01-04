package com.sample.test.designpattern.command;

public class MarioCharacterReceiver {

    private String name;

    public  void moveUp(){
        System.out.println(getName()+"  jumping up");
    }

    public void moveLeft(){
        System.out.println(getName() +" moving left");
    }

    public void moveDown(){
        System.out.println(getName()+"  moving down...");
    }

    public void moveRight(){
        System.out.println(getName() +" moving right ..");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
