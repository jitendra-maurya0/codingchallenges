package com.sample.test.sorting;

import com.google.gson.internal.$Gson$Preconditions;

import java.util.Arrays;

public class Quick {

    int[] sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        quick(arr, low, high);
        return arr;

    }

    void quick(int[] arr, int start, int end) {
        int part = partition(arr, start, end);
        if (part - 1 > start) {
            quick(arr, start, part - 1);
        }

        if(part+1 <end) {
            quick(arr, part + 1, end);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        for (int i = low; i < high; i++) {
            if(pivot > arr[i]){
                int temp = arr[low];
                arr[low] = arr[i];
                arr[i] = temp;
                low++;
            }
        }
        int temp = arr[low];
        arr[low] = pivot;
        arr[high] = temp;
        return low;
    }

    int findKthLargestEl(int[] arr,int k){
        if(k <1 || arr == null) return 0;
        return kth(arr.length-k+1, arr,0, arr.length-1);
    }

    int kth(int k,int[]arr,int start,int end){
         int pivot = arr[end];
         int left = start;
         int right = end;
         while (true){

             while (arr[left] < pivot && left < right){
                 left ++;
             }

             while (arr[right] >= pivot && right > left){
                 right--;
             }

             if(left == right){
                 int temp = arr[left];
                 arr[left] = arr[right];
                 arr[right] = temp;
                 break;
             }
         }

         if(k == left+1){
             return pivot;
         }else if(k < left+1){
            return kth(k,arr,start,left-1);
         }else{
            return kth(k,arr,left+1,end);
         }

    }

    public static void main(String[] args) {
        int []arr = {3,1,7,-1,0};
        Quick quick = new Quick();
        System.out.println(Arrays.toString(quick.sort(arr)));
        //System.out.println(quick.findKthLargestEl(arr,2));
    }
}
