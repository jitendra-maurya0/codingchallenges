package com.sample.question.sorting;

import java.util.Arrays;

/**
 * it is classic algorithm used to sort elements
 * when elements are small
 */
public class InsertionSort {

    static void sort(int[]arr){

        for (int j = 1; j <arr.length ; j++) {

            int key = arr[j];

            //insert key in right place

            int i = j-1;
            while (i>0 && arr[i] >key){
                arr[i+1] = arr[i];
                i--;

            }
            arr[i+1] = key;
        }

        System.out.println(Arrays.toString(arr));
    }
    static void sortNonIncresingOrder(int[]arr){

        for (int j = 1; j <arr.length ; j++) {

            int key = arr[j];

            //insert key in right place

            int i = j-1;
            while (i>0 && arr[i] < key){
                arr[i+1] = arr[i];
                i--;

            }
            arr[i+1] = key;
        }


        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[]arr = {1,4,6,7,3};
       // sort(arr);
        sortNonIncresingOrder(arr);
    }
}
