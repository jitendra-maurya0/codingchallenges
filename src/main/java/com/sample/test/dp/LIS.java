package com.sample.test.dp;

import java.util.Arrays;

/**
 * find longest increasing subsequence in array
 * 3,4,-1,0,6,2,3
 * Ans: 4
 */
public class LIS {
    
    static int findLongestSubSequenceInArray(int[]arr){
        
        int[]temp = new int[arr.length];
        Arrays.fill(temp,1);

        for (int i = 1; i <arr.length ; i++) {

            for (int j = 0; j <i ; j++) {

                if(arr[i] > arr[j] && temp[i] <temp[j]+1){
                    temp[i] = temp[j]+1;
                }
            }

        }

       return getMax(temp);
    }

    static int getMax(int[]arr){
        int max = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    static int LIOES(int[]arr){
        int[]temp = new int[arr.length];
        Arrays.fill(temp,1);
        for (int i = 1; i <arr.length ; i++) {

            for (int j = 0; j <arr.length ; j++) {

                if(arr[i] > arr[j] && (arr[i]+arr[j])%2 != 0){
                    temp[i] = temp[j]+1;
                }
            }

        }
        return getMax(temp);
    }

    public static void main(String[] args) {
        int[][]arr = {{3,4,-1,0,6,2,3},{3, 10, 2, 1, 20}};
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(findLongestSubSequenceInArray(arr[i]));
            System.out.println("LIOS");
            System.out.println(LIOES(arr[i]));
            System.out.println("-------------");
        }

    }
}
