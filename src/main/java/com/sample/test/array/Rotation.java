package com.sample.test.array;

import java.util.Arrays;

/**
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 */
public class Rotation {

    /**
     * rotate array by d using auxilary space
     * @param arr
     * @param d
     */
    public static void rotate(int[]arr,int d){
        int[]temp = new int[d];
        for(int i=0;i<d;i++){
            temp[i] = arr[i];
        }

        for (int i = 0; i <arr.length-d ; i++) {
            arr[i] = arr[i+d];
        }

        for (int i = (arr.length-d),j=0; i <arr.length ; i++) {
            arr[i] = temp[j];
            j++;
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void rotateUsingReverse(int[]arr,int d){

        rotate(arr,0,d-1);
       rotate(arr,d,arr.length-1);
       rotate(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    static void rotate(int[]arr, int s,int n){

        while (s<n) {
            int temp = arr[s];
            arr[s] = arr[n];
            arr[n] = temp;
            n--;
            s++;
        }
    }

    /*

     Block swap algo for reverse array
     */
    static void leftRotate(int arr[], int d, int n)
    {
        int i, j;
        if(d == 0 || d == n)
            return;
        i = d;
        j = n - d;
        while (i != j)
        {
            if(i < j) /*A is shorter*/
            {
                swap(arr, d-i, d+j-i, i);
                j -= i;
            }
            else /*B is shorter*/
            {
                swap(arr, d-i, d, j);
                i -= j;
            }
            // printArray(arr, 7);
        }
        /*Finally, block swap A and B*/
        swap(arr, d-i, d, i);

        System.out.println(Arrays.toString(arr));
        System.out.println(findPivot(arr));
    }

   static void swap(int arr[], int fi, int si, int d)
    {
        int i, temp;
        for(i = 0; i<d; i++)
        {
            temp = arr[fi + i];
            arr[fi + i] = arr[si + i];
            arr[si + i] = temp;
        }
    }

    static int searchInSortedAndRotatedArray(int[]arr, int el){
        int pivot = findPivot(arr);

        if(pivot == -1){
            return binarySearch(arr,0,arr.length-1,el);
        }

        if(arr[pivot] == el)
            return pivot;
        if(arr[0] <= el){
            return binarySearch(arr,0,pivot-1,el);
        }

        return     binarySearch(arr,pivot+1,arr.length-1,el);

    }

    static int binarySearch(int[]arr,int start ,int end, int el){


        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] == el) {
                return mid;
            }

            if (el > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return  -1;

    }

    static int findPivot(int[]arr){
        for (int i = 0,j=1; j < arr.length; j++) {

            if(arr[i] > arr[j]){
                return i;

            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]a = {1,2,3,4,5,6,7};
        int d = 2;
        leftRotate(a,d,7);

        int[]rotated = {3,4,5,6,7,1,2};

        System.out.println(searchInSortedAndRotatedArray(rotated,4));

    }
}
