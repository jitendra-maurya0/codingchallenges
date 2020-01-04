package com.sample.question.array;

import java.util.Arrays;

public class ProductOfAllElementExceptItSelf {

    public static int[] solution(int[]arr){
        int[]temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = product(i,arr);
        }
        return  temp;
    }

    static int product(int indexToIgnore,int []arr){
        int prod =1;
        for(int i = 0;i<arr.length;i++){
            if(i == indexToIgnore){
                continue;
            }else{
                prod *= arr[i];
            }
        }
        return prod;
    }

    public static void main(String[] args) {

        int[]test = {1,2,3,4};
        System.out.println(Arrays.toString(solution(test)));

    }
}
