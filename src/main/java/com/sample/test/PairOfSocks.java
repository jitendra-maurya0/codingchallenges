package com.sample.test;

import java.util.Arrays;

public class PairOfSocks {

    static int getPairs(int n, int[] arr) {
        Arrays.sort(arr);
        int start = 0;
        int end = 1;
        int pair = 0;

        while (end < n){

            if(arr[start] == arr[end]){
                start = end+1;
                end = end+2;
                pair++;
            }else{
                start++;
                end++;
            }
        }

        return pair;


    }

    public static void main(String[] args) {
        int[]arr = {1,2,1,2,3,2};
        System.out.println(getPairs(6,arr));
    }
}
