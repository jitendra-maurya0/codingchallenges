package com.sample.question.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcutorServiceTest {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Test());

    }
}

class Test extends Thread{
    @Override
    public void run(){
        System.out.println("hello java");
    }
}
