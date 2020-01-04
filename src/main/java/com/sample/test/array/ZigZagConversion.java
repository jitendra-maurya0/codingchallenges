package com.sample.test.array;

import java.util.Arrays;

/**
 * zig zag conversion
 */
public class ZigZagConversion {


    static void zigzag(int[]input){

            boolean isLess = true;
            for (int i = 0; i < input.length - 1; i++) {
                if (isLess) {
                    if (input[i] > input[i + 1]) {
                        swap(input, i, i + 1);
                    }
                } else {
                    if (input[i] < input[i + 1]) {
                        swap(input, i, i + 1);
                    }
                }
                isLess = !isLess;
            }
            System.out.println(Arrays.toString(input));
        }


    static void swap(int[]arr,int s,int q){
        int temp = arr[s];
        arr[s] = arr[q];
        arr[q] = temp;
    }

    public static void main(String[] args) {
        int[]arr = {9,2,3,4,5,6,7};

        int a =1234512345;
        System.out.println(a);

        zigzag(arr);
    }
}
