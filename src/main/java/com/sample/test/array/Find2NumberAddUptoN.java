package com.sample.test.array;

import java.util.Arrays;

public class Find2NumberAddUptoN {

    public int[] printPairOfNumber(int[]arr,int n){
        int[]temp = new int[2];
        for(int i =0;i<arr.length;i++){
            int candidate = n - arr[i];
            int second = search(i+1,arr.length,arr,candidate) ;
            if(second != -1){
                temp[0] = arr[i];
                temp[1] = second;
                break;
            }


        }
        return temp;
    }

    public int search(int startIndex,int endIndex,int[]arr,int elementToSearch){

        int candidate =-1;
        for (int i = startIndex; i <endIndex ; i++) {

            if(arr[i] == elementToSearch){
                candidate = elementToSearch;
                break;
            }
        }
        return candidate;

//        while (startIndex < endIndex){
//            int mid = (startIndex+endIndex)/2;
//            if(arr[mid] == elementToSearch){
//                return elementToSearch;
//            }
//            if(arr[mid] < elementToSearch){
//                startIndex = mid+1;
//            }else{
//                endIndex = mid-1;
//            }
//        }
//        return -1;
    }

    public static void main(String[] args) {
     int[]arr = {1, 21, 3, 14, 5, 60, 7, 6};
        System.out.println(Arrays.toString(new Find2NumberAddUptoN().printPairOfNumber(arr,27)));
    }
}
