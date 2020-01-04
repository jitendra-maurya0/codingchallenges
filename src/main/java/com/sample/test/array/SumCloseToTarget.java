package com.sample.test.array;

import java.util.Arrays;

public class SumCloseToTarget {

    static int get3SumCloseToTarget(int[]arr,int target){

        int minimalDist = Integer.MAX_VALUE;
        Arrays.sort(arr);
         int res=0;
        for (int i = 0; i <arr.length-2 ; i++) {
            int l =i+1,r = arr.length-1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if(sum == target) return target;
                else if(sum > target){
                    if(sum -target < minimalDist){
                        minimalDist = sum-target;
                        res = sum;
                    }
                    r--;
                }else{
                    if(target - sum < minimalDist){
                        minimalDist = target-sum;
                        res = sum;
                    }
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[]arr  = {1,-1,2,3};
        int target = 2;
        System.out.println(get3SumCloseToTarget(arr,target));
    }
}
