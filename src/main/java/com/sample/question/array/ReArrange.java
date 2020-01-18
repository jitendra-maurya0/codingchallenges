package com.sample.question.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array, can you re-arrange its elements in such a way that the negative elements appear at one side and positive elements appear at the other?
 */
public class ReArrange {

    /**
     * time complexity is O(n) and space complexity is increased as new array is created
     * @param arr
     */
    public static void reArrange(int[] arr) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            if(arr[i] <0){
                list.add(arr[i]);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i] >0){
                list.add(arr[i]);
            }
        }
        for(int i=0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        System.out.println(Arrays.toString(arr));

    }

    /**
     * time complexity is still O(n) with no extra space
     * @param arr
     */
    public static void reArrangeInPlace(int[] arr)
    {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {   // if negative number found
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j]; // swapping with leftmost positive
                    arr[j] = temp;
                }
                j++;
            }
        }
    }

    /**
     * Given an <b>sorted</b> array, can you re-arrange the elements such that the first position will have the largest number,
     * the second will have the smallest, the third will have the second largest, and so on
     * @param arr
     * The time complexity of this problem is O(n) as the array is iterated over once.
     */
    public static void reArrangeArrayInMinMaxForm(int[]arr){
        int[] result = new int[arr.length];

        int pointerSmall = 0;     //PointerSmall => Start of arr
        int pointerLarge = arr.length - 1;   //PointerLarge => End of arr

        //Flag which will help in switching between two pointers
        boolean switchPointer = true;

        for (int i = 0; i < arr.length; i++) {
            if (switchPointer)
                result[i] = arr[pointerLarge--]; // copy large values
            else
                result[i] = arr[pointerSmall++]; // copy small values

            switchPointer = !switchPointer;   // switching between samll and large
        }

        for (int j = 0; j < arr.length; j++) {
            arr[j] = result[j];    // copying to original array
        }
        System.out.println(Arrays.toString(result));
    }

    /**
     * time complexity is O(n) with O(1) extra space
     * @param arr
     */
    public static void reArrangeArrayInMinMaxWithoutExtraSpace(int[]arr){
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array
        for( int i = 0; i < arr.length; i++) {
            // at even indices we will store maximum elements
            if (i % 2 == 0){
                arr[i] += (arr[maxIdx] % maxElem ) * maxElem;
                maxIdx -= 1;
            }
            else { // at odd indices we will store minimum elements
                arr[i] += (arr[minIdx] % maxElem ) * maxElem;
                minIdx += 1;
            }
        }
        // dividing with maxElem to get original values.
        for( int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElem;
        }
    }

    public static void main(String[] args) {
        int[]arr = {10,-1,20,4,5,-9,-6};
        int[] minMax = {1, 2, 3, 4, 5, 6};
        reArrangeArrayInMinMaxForm(minMax);
    }
}
