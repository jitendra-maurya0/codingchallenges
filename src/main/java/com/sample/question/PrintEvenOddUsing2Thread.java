package com.sample.question;

public class PrintEvenOddUsing2Thread implements Runnable{

    static Object lock=new Object();

    public int PRINT_NUMBERS_UPTO=10;
    static int  number=1;
    int remainder;

    PrintEvenOddUsing2Thread(int remainder){
        this.remainder = remainder;
    }
    @Override
    public void run() {

        while (number < PRINT_NUMBERS_UPTO){

            synchronized (lock) {
                while (number % 2 != remainder) {
                    try{
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
                System.out.println(Thread.currentThread().getName() +"  "+number);
                number++;
                lock.notifyAll();
            }

        }

    }

    public static void main(String[] args) {
        PrintEvenOddUsing2Thread t1 = new PrintEvenOddUsing2Thread(1);
        PrintEvenOddUsing2Thread t2 = new PrintEvenOddUsing2Thread(0);

        new Thread(t1,"odd").start();
        new Thread(t2,"even").start();
    }
}
