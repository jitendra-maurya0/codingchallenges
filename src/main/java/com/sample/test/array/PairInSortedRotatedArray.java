package com.sample.test.array;

/**
 * Given an array that is sorted and then rotated around an unknown point. Find if the array has a pair with a given sum ‘x’. It may be assumed that all elements in the array are distinct
 * Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16
 * Output: true
 * There is a pair (6, 10) with sum 16
 *
 */
public class PairInSortedRotatedArray {

    static boolean pair(int[]arr,int sum){

        int i;
        int j;
        for(i=0,j=1; j< arr.length;j++){

            if(arr[i] > arr[j])
                break;
            i++;
        }

        //smallest element
        int l = (i+1)%arr.length;

        int r = i;

        while (l != r){

            if(arr[l] +arr[r] == sum)
                return true;
            if(arr[l] +arr[r] < sum)
                l = (l+1)%arr.length;
            else
                r = (arr.length+r-1)%arr.length;
        }
        return false;

    }

    public static void main(String[] args) {
        int[]arr = {3,4,5,6,7,1,2};
        System.out.println(pair(arr,11));
    }
}
