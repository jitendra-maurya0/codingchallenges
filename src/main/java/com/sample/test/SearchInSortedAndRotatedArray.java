package com.sample.test;

public class SearchInSortedAndRotatedArray {

    public static int search(int[] nums, int target) {

        int start =0, end = nums.length-1;
        int pi = findPivot(nums);
        if(pi == -1) return -1;
        if(nums[pi] == target ){

          return  pi;
        }

        if(nums[pi] > target){
            end = pi;
        }else {
            start = pi-1;
        }

        while (start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(target > nums[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return -1;
    }

     static int findPivot(int[]num){

        if(num.length ==0 ||  num == null){
            return -1;
        }
        int start =0; int end = num.length-1;
        if(num[start] <= num[end]){
            return 0;
        }

        while (start <= end){
            int mid = start + (end - start)/2;

            if(num[mid] > num[mid+1]){
                return mid+1;
            }else if(num[mid] >= num[mid+1])
            {
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]arr = {7,0,1,2,3,4,5,6};
        int[]x = {};
        int[]a = {3,1};
        System.out.println(search(arr,3));
    }

}

