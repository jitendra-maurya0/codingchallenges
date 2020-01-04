package com.sample.question.designpattern.strategy.example2;

public class CreditCardAlgo implements Payment {

    private String name;
    private String cardNumber;

    @Override
    public void pay(double amount) {

        System.out.println("Pay with credit card");

    }

    public CreditCardAlgo(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
