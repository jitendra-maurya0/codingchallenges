package com.sample.question;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int max =0;
        for(int i=0;i<height.length;i++){
               for(int j=i+1;j<height.length;j++){
                   max = Math.max(max,Math.min(height[i],height[j])*(j-i));
               }
            }

         return  max;
    }

    public static void main(String[] args) {
        int[]arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
