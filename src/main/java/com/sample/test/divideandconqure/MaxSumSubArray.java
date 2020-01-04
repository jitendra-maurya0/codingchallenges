package com.sample.test.divideandconqure;

/**
 * find maximum sum  sub array in give array
 */
public class MaxSumSubArray {

    static void findMaxCrossingSubArray(int[]arr,int low,int mid,int high){
        int lMax = Integer.MIN_VALUE;
         int lSum =0;
         int maxLeft =0;
        for (int i = mid; i < low; i--) {
            lSum = lSum + arr[i];
            if(lSum > lMax){
                lMax = lSum;
                maxLeft =i;
            }
        }

        int rMax = Integer.MIN_VALUE;
        int maxRight =0;
        int rSum =0;
        for (int i = mid+1; i <high ; i++) {
            rSum = rSum+ arr[i];
            if(rSum > rMax )
            {
                rMax = rSum;
                maxRight = i;
            }
        }
        System.out.printf("%d,%d,%d",maxLeft,maxRight,(lSum+rSum));
    }

//    static int findMaximumSum(int[]arr,int low,int high){
//        if(high == low)
//            System.out.printf("%d,%d,%d",low,high,arr[low]);
//        else{
//            int mid = (low+high)/2;
//            findMaxCrossingSubArray(arr,low,mid);
//        }
//    }

    public static void main(String[] args) {

        int[]input = {13,-3,-25,20,-3,16,-23,18,20,-7,12,-5,-22,15,-4,7};

        int mid = (input.length)/2;

        findMaxCrossingSubArray(input,0,mid,input.length);

    }
}
