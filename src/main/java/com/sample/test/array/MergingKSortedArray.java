package com.sample.test.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergingKSortedArray {

    static void merge(int[][]arr){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            int[]a = arr[i];
            for (Integer k: a){
                queue.offer(k);
            }
        }
        while (!queue.isEmpty()){
            result.add(queue.poll());
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };
        int[][]arr = {arr1,arr2,arr3};
        merge(arr);
    }
}
