package com.sample.test;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it
 * will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobor {

   static int rob(int[]arr){
        int max =0;
        int sub1Max=0;
        int sub2Max =0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(sub2Max + arr[i], sub1Max);
            sub2Max = sub1Max;
            sub1Max = max;
        }
        return max;
    }


    public static void main(String[] args) {
        int[]arr = {1,2,3,1};
        System.out.println(rob(arr));
    }
}
