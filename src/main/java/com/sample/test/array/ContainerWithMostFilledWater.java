package com.sample.test.array;

/**
 * given non -ve integers find two lines contains most of water
 */
public class ContainerWithMostFilledWater {

    static int maxArea(int[]heights){
        int i =0; int j = heights.length-1;
        int max = 0;
        while (i<j){
            max = Math.max(max,(j-i)*Math.min(heights[i],heights[j]));
            if(heights[i] >heights[j]){
                j--;
            }else{
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3};
        System.out.println(maxArea(arr));
    }

}
