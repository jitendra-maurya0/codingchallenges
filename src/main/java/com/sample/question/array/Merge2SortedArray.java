package com.sample.question.array;

import java.util.Arrays;

public class Merge2SortedArray {

    public int[] merge(int[]arr1,int[]arr2){

        int n1 = arr1.length;
        int n2 = arr2.length;
        int[]arr = new int[arr1.length+arr2.length];

        int i =0, j = 0, k =0;
        while (i < n1 && j < n2){
            if(arr1[i] <= arr2[j]){
                arr[k] = arr1[i];
                i++;

            }else{
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i<arr1.length){
            arr[k] = arr1[i];
            k++;
            i++;
        }

        while (j < arr2.length){
            arr[k] = arr2[j];
            k++;
            j++;
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr1 = { 1, 3, 5,20 };
        int[] arr2 = { 2, 4, 6, 8 };
        System.out.println(Arrays.toString(new Merge2SortedArray().merge(arr1,arr2)));
    }
}
