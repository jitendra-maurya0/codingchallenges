package com.sample.question.array;

import java.util.*;

/**
 * Given an array, find the first integer which is unique in the array. Unique means the number does not repeat and appears only once in the whole array. Implement your solution in Java and see if it runs correctly!
 */
public class FirstNonRepeatingNumber {
    static int getFirstUnique(int[]arr){

        Map<Integer, Integer> countElements = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            countElements.put(arr[i],0);
        }
        for(int i = 0; i < arr.length; i++){
            countElements.put(arr[i],countElements.get(arr[i])+1);
        }
        for(int i = 0; i < arr.length; i++){
            if(countElements.get(arr[i]) <= 1){
                return arr[i];
            }
        }
        return - 1;

    }

    /**
     * time complexity is n*n
     * @param arr
     * @return
     */
    static int findFirstNonRepeated(int[]arr){
        boolean repeated = false;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (arr[i] == arr[j] && i != j) {
                    repeated = true;
                    break;
                }
            }

                if(repeated == false){
                    return arr[i];
                }else{
                    repeated = false;
                }


        }
        return  -1;
    }

    public static void main(String[] args) {

        int[]sample = {9, 2, 3, 2, 6, 6};
        int[]sample1 = {4,4,4,3};
        System.out.println(findFirstNonRepeated(sample));

    }
}
