package com.sample.question.designpattern.strategy.example2;

public class PayPalAlgo implements Payment {
    @Override
    public void pay(double amount) {

        System.out.println(amount+"  paid by paypal");
    }

    private String password;
    private String email;

    public PayPalAlgo(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
