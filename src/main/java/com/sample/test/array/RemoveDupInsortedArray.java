package com.sample.test.array;

import java.util.Arrays;

public class RemoveDupInsortedArray {

    int removeDuplicate(int []arr){
           int j=0;
           int i=1;
        for (; i <arr.length ; i++) {

            if(arr[i] != arr[j]){
                j++;
                arr[j] = arr[i];
            }

        }
        return j+1 ;
    }

    public static void main(String[] args) {
        RemoveDupInsortedArray removeDupInsortedArray = new RemoveDupInsortedArray();
        int[]arr = {1,1,2};
        System.out.println( (removeDupInsortedArray.removeDuplicate(arr)));
    }
}
