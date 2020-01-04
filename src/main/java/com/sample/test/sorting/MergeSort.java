package com.sample.test.sorting;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class MergeSort {

    public void mergeSort(int []arr,int n){
        if(n < 2) return;

        int mid =  n/2;
        int[]left = new int[mid];
        int[]right = new int[n-mid];
        System.arraycopy(arr,0,left,0,mid);
        System.arraycopy(arr,mid,right,0,n-mid);
        mergeSort(left,left.length);
        mergeSort(right,right.length);
        merge(arr,left,right,mid,n-mid);

        System.out.println(Arrays.toString(arr));
    }

    private void merge(int[] arr, int[] left, int[] right, int start, int end) {

        int i=0,j=0,k=0;
        while (i< start && j < end){
            if(left[i] <=right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while (i < start){
            arr[k++] = left[i++];
        }

        while (j < end){
            arr[k++] = right[j++];
        }

    }

    public static void main(String[] args) {
        int[]arr = {1,3,5,-1,-2};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr,arr.length);

    }
}
