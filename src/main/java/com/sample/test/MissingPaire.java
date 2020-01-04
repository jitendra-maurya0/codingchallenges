package com.sample.test;

public class MissingPaire {

    public static int solution(int[] A) {
        int[]freq = new int[A.length];
        int count=0;

        for(int i=0;i<A.length;i++){
            int temp = A[i];
            for(int j=0;j<A.length;j++){

                if(temp == A[j]){
                    count++;
                }
            }
            freq[i] = count;
            count=0;
        }

        int i;
        for(i=0;i<freq.length;i++){
            if(freq[i] == 1)
                break;

        }
        return A[i];
    }

    public static void main(String[] args) {
        int[]arr = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(arr));
    }
}
