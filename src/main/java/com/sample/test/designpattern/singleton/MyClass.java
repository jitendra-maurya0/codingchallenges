package com.sample.test.designpattern.singleton;

public class MyClass {

    static volatile  MyClass uniqueInstance;

    private MyClass(){

    }

    public static  MyClass getInstance(){

        // adding synchronized key word makes our singleton thread safe
        if(uniqueInstance == null){
            synchronized (MyClass.class){
                if(uniqueInstance == null){
                    uniqueInstance = new MyClass();
                }
            }
           
        }
        return uniqueInstance;
    }
}
