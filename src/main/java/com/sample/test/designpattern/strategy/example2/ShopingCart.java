package com.sample.test.designpattern.strategy.example2;

import java.util.ArrayList;
import java.util.List;

public class ShopingCart {

    List<Product> productList;

    public ShopingCart() {
        this.productList = new ArrayList<>();
    }


    public void addProduct(Product product){
        productList.add(product);
    }

    public void removeProduct(Product product){
        productList.remove(product);
    }

    public Double calculateTotal(){
        double sum =0.0;

        for (Product product:productList){
            sum += product.getPrice();
        }
        return  sum;
    }

    public void  pay(Payment paymentStrategy){
        double amount = calculateTotal();
        paymentStrategy.pay(amount);
    }
}
