package com.sample.question.array;

/**
 * give an array find the no which is missing
 */
public class MissingNumber {

    int getNumber(int[]arr){
        int miss =0;
        for (int i = 0; i <arr.length ; i++) {

            miss ^=(i+1)^arr[i];

        }
        return miss;
    }

    int getNonRepeatingNumber(int[]arr){
        int mis =0;
        for (int i = 0; i <arr.length ; i++) {
            mis ^= arr[i];
        }
        return mis;
    }


    public static void main(String[] args) {
        int[]arr = {1,-1,4,0,6,3,2};
        int[]arr1 = {2,2,1,3,3};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.getNonRepeatingNumber(arr1));
    }


}
