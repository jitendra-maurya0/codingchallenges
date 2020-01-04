package com.sample.question.array;

import java.util.Arrays;

/**
 * find element who apears more than n/2 times or n/3 times
 *   A A A C C B B C C C B C C
 *  ^
 * ?:0
 * We will sweep down the sequence starting at the pointer position shown above.
 *
 * As we sweep we maintain a pair consisting of a current candidate and a counter. Initially, the current candidate is unknown and the counter is 0.
 *
 * When we move the pointer forward over an element e:
 *
 * If the counter is 0, we set the current candidate to e and we set the counter to 1.
 * If the counter is not 0, we increment or decrement the counter according to whether e is the current candidate.
 * When we are done, the current candidate is the majority element, if there is a majority.
 */
public class Mejoritry {

    /**
     * O(n) solutions
     */
    int getMejority(int[]arr){
        int count =0; int current=0;
        for (int i = 0; i <arr.length ; i++) {
            if(count ==0){
                current = arr[i];
                count++;
            }else if(current == arr[i]){
                count++;
            }else{
                count--;
            }
        }
        return current;
    }

    int getMejorityInNLogN(int[]arr){
        if(arr.length ==1){
            return arr[0];
        }
        Arrays.sort(arr);
        return arr[arr.length/2];
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,2,2,2};
        Mejoritry mejoritry = new Mejoritry();
        System.out.println(mejoritry.getMejority(arr));
    }
}
