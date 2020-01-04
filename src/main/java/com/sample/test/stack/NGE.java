package com.sample.test.stack;

import java.util.Stack;

/**
 * find next greatest element in given array for any element
 *
 */
public class NGE {

    static void printNGE(int[]arr){

        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);


        int el; int next;
        for(int i=1;i<arr.length;i++){

              next = arr[i];
            if(!stack.isEmpty()){

                el = stack.pop();


                while (el < next){
                    System.out.println(el +" ------> "+next);

                    if (stack.isEmpty()) {
                         break;
                    }
                    el = stack.pop();
                }

                if(el > next){
                    stack.push(el);
                }

            }

            stack.push(next);
        }

        while (!stack.isEmpty()){
            el = stack.pop();
            next = -1;
            System.out.println(el +" ------> "+next);
        }


    }


    public static void main(String[] args) {

        int[]ar=  {1,3,5,6,7,78};
        int[]ar1 = { 11, 13, 21, 3};
        printNGE(ar);
    }
}
