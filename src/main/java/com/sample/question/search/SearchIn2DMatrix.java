package com.sample.question.search;

/**
 * write efficient algorithm to find element in 2D matrix
 */
public class SearchIn2DMatrix {

    boolean exits(int[][]arr,int target){
        int m = arr.length-1;
        int n = arr[0].length-1;

        int i =m;
        int j=0;
        while (i >=0 && j<= n){
            if(target == arr[i][j]){
                return true;
            }else if(target < arr[i][j]){
                i--;
            }else{
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][]arr = {{1,2,4},{5,6,7},{9,10,13}};
        System.out.println(new SearchIn2DMatrix().exits(arr,0));
    }
}
