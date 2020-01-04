package com.sample.question.annonymus;

import java.util.Arrays;

public class Close2Zero {

    static int getNumberCloseTo0(int []arr){
        int near = arr[0];
        int curr = 0;
        Arrays.sort(arr);
        for (int i = 0; i <arr.length ; i++) {
            curr = arr[i]*arr[i];
            if(curr <= near*near){
                near = arr[i];
            }
        }
        return near;
    }

    public static void main(String[] args) {
        int[]arr = {-2,2,3,0};
        System.out.println(getNumberCloseTo0(arr));
    }
}
