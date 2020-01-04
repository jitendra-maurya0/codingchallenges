package com.sample.test.designpattern.strategy.example2;

public class Main {

    public static void main(String[] args) {
        ShopingCart shopingCart = new ShopingCart();

        Product pants = new Product("234",25.0);
        Product shirts = new Product("shirtes",10.0);

        shopingCart.addProduct(shirts);
        shopingCart.addProduct(pants);
        shopingCart.pay(new PayPalAlgo("jeetu345@gmail.com","password"));
        shopingCart.pay(new CreditCardAlgo("jitendra","x.y.z"));
    }
}

