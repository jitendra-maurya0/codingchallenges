package com.sample.question.designpattern.strategy.example2;


public class Product {

    private String upcCode;
    private double price;

    public Product(String upcCode, double price) {
        this.upcCode = upcCode;
        this.price = price;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
