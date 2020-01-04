package com.sample.test;

public class Sample {

    private String value;

    public String getValue() {
        return "hello";
    }

    public void setValue(String s){
        this.value=s;
    }

    public static void main(String[] args) {
        Sample sample = new Sample();

        System.out.println(sample.value);


    }

}
