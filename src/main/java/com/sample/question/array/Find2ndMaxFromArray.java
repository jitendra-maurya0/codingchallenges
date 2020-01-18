package com.sample.question.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class Find2ndMaxFromArray {

    public static int secondMax(int[]arr){
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i <arr.length ; i++) {
            queue.add(arr[i]);
        }
        queue.remove();
        return queue.peek();
    }

    /**
     * traversing using single loop time complexity is O(n)
     * @param arr
     * @return
     */
    public static int findSecondMaximum(int[] arr) {

        int max = Integer.MIN_VALUE;;
        int secondmax = Integer.MIN_VALUE;

        // Keep track of Maximum value, whenever the value at an array index is greater
        // than current Maximum value then make that max value 2nd max value and
        // make that index value maximum value
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondmax = max;
                max = arr[i];
            }
            else if (arr[i] > secondmax && arr[i] != max) {
                secondmax = arr[i];
            }
        }//end of for-loop

        return secondmax;
    } //end of findSecondMaximum

    public static void main(String[] args) {
        int[]arr = {9,2,3,6};
        System.out.println(secondMax(arr));
    }
}
