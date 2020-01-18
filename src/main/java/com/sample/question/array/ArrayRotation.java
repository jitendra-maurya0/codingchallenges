package com.sample.question.array;

public class ArrayRotation {

    static int[] rotate(int[]A,int K){

        for(int i=0;i<K;i++){
            int n = A.length-1;
            int last = A[n];
            int k = 0;

            while(k < n){
                A[n] = A[--n];

            }
            A[n]= last;


        }
        return A;

    }

    static int getRotationCount(int[]arr,int low,int high){

          if(high < low)
              return 0;
          if (high == low)
              return low;

        int mid = low + (high -low)/2;

        if(low < mid &&  arr[mid-1] > arr[mid]  ){
            return mid;
        }
        if(mid < high && arr[mid+1] <  arr[mid]){
            return mid+1;
        }
        if(arr[high] > arr[mid])

            return getRotationCount(arr,low,mid-1);

        return getRotationCount(arr,mid+1,high);

    }

    public static void rotateArrayBy1(int[] arr){

        int rightEl = arr[arr.length-1];
        for(int i =arr.length-1;i>0;i--){
            arr[i] = arr[i-1];
        }
        arr[0] = rightEl;

    }

    static void rotateArrayWithK(int[]arr,int k){
        int[]temp = new int[arr.length*2];
        System.arraycopy(arr,0,temp,0,arr.length);
        System.arraycopy(arr,0,temp,arr.length,arr.length);

        for (int i = (k%arr.length); i <(k% arr.length +arr.length) ; i++) {
            System.out.print(" "+temp[i]);
        }
    }

    public static void main(String[] args) {
//        int[]a = {3,8,9,7,6};
//        int k = 3;
//        System.out.println(Arrays.toString( rotate(a,k)));
//        System.out.println(getRotationCount(a,0,a.length-1));
        int[]arr ={1,2,3,4,5,6,7};

        rotateArrayWithK(arr,2);
        System.out.println();
        rotateArrayWithK(arr,3);
    }
}
