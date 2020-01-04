package com.sample.question;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Program {

   static ExecutorService ex = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        ex.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }




}
