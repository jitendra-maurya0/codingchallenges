package com.sample.test;

import java.util.Arrays;

public class Distinct {

     static int solution(int[] A) {
        return Arrays.stream(A).distinct().findAny().getAsInt();


    }



    public static void main(String[] args) {
        int[]a = {1,1,1};
        int[]b = {2,1,1,2,3,1,1};
       // String[]a = {"1","1","3"};
        System.out.println(solution(b));
    }
}
