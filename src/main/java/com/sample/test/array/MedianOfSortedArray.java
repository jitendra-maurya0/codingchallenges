package com.sample.test.array;

public class MedianOfSortedArray {

    public int getMedian(int[]arr1, int[] arr2){
        int total = (arr1.length+ arr2.length);
        if(total%2 == 0){
           return  (get(arr1,0,arr1.length-1,arr2,0,arr2.length-1,total/2)+get(arr1,0,arr1.length-1,arr2,0,arr2.length-1,total/2-1))/2;
        }else{
            return get(arr1,0,arr1.length-1 ,arr2,0,arr2.length-1,total/2);
        }
    }

    private int get(int[] arr1, int i, int i1, int[] arr2, int i2, int i3, int k) {
        if(i1 < i){
            return arr2[i2+k];
        }
        if(i3 < i2){
            return arr1[i1+k];
        }
        if(k==0){
            return Math.min(arr1[i],arr2[i2]);
        }

        int len1 = i1 -i+1;
        int len2 = i3 -i2+1;
        int m1 = k*len1/(len1+len2);
        int m2 = k-m1-1;
        m1 +=i;
        m2 +=i2;
        if(arr1[m1] < arr2[m2]){
            k = k-(m1-i+1);
            i3 = m2;
            i = m1+1;
        }else{
            k = k-(m2-i2+1);
            i1 = m1;
            i2 = m2+1;
        }
        return get(arr1,i,i1,arr2,i2,i3,k);
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3};
        int[]arr1 = {5,6,8,10};
        MedianOfSortedArray medianOfSortedArray = new MedianOfSortedArray();
        int m = medianOfSortedArray.getMedian(arr1,arr);
        System.out.println(m);
    }
}
