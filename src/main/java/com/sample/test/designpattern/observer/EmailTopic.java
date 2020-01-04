package com.sample.test.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class EmailTopic implements Subject {

    private List<Observer> observers;

    private String message;

    public EmailTopic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if(observer == null)
            throw new NullPointerException("null object/observer");
        if(!observers.contains(observer)){
            observers.add(observer);
        }

    }

    @Override
    public void unregister(Observer observer) {

        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for (Observer observer: observers){
            observer.update();
        }
    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.message;
    }

    public void postMessage(String message){
        System.out.println("message posted to topic: "+message);
        this.message =message;
        notifyObservers();
    }
}
