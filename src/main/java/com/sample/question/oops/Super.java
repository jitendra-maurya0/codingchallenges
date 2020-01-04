package com.sample.question.oops;

public class Super {

   public void display(int x,Long y){

       System.out.println("displaying object");
   }

   public void display(long x,int y){
       System.out.println("displaying primitive");


   }

    public static void main(String[] args) {
       Super su =  new Super();
       su.display(3,5);
    }


}
