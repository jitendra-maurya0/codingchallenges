package com.sample.question.annonymus;

public class MinJump {

    static int minJump(int x,int y, int d){
        long start = System.currentTimeMillis();
        int count=0;
        if(y >x && d > 0){
            while (x < y){
                x = x+d;
                count++;
            }
        }
        System.out.println("total time = "+ (System.currentTimeMillis()-start));
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minJump(3,999111321,7));
    }
}
