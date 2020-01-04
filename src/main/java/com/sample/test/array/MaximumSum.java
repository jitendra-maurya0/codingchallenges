package com.sample.test.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Sliding Window Maximum (Maximum of all subarrays of size k)
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 */
public class MaximumSum {

    public List<Integer> getMaxSumWithSlidingWindow(int[]arr,int windowSize){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <arr.length-windowSize ; i++) {
            int max = getMax(arr,i,i+windowSize);
            result.add(max);
        }
        return result;
    }

    private int getMax(int[] arr, int i, int i1) {
        int max = arr[i];
        for (int j = 1; j <=i1; j++) {
            if(max < arr[j]){
                max = arr[j];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}; int K = 3;
        MaximumSum maximumSum = new MaximumSum();
        System.out.println( maximumSum.getMaxSumWithSlidingWindow(arr,K));
    }


}
