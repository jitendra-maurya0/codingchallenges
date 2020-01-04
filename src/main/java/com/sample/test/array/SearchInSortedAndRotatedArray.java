package com.sample.test.array;

public class SearchInSortedAndRotatedArray {

    /**
     * find an element in sorted and rotated array assuming all elements are unique
     * we can modify out exiting binary search algorithm
     * complexity of algorithm O(nlogn)
     * @param arr
     * @param startIndex
     * @param endIndex
     * @param key
     * @return - 1 if not found
     *
     * first half condition
     *  if (arr[st] <= arr[mid] && key <= arr[mid] && key >= arr[st]) {
     *       return binary_search( arr, st, mid-1, key);
     *     }
     *
     *     second half condition
     *
     *     else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]) {
     *       return binary_search(arr, mid+1, end, key);
     *     }
     *     else if (arr[end] <= arr[mid]) {
     *       return binary_search( arr, mid+1, end, key);
     *     }
     *     else if (arr[st] >= arr[mid]) {
     *       return binary_search( arr, st, mid-1, key);
     *     }
     */
    public int  binarySearch(int[]arr,int startIndex,int endIndex,int key){

        if(startIndex > endIndex){
            return  -1;
        }
        int mid = startIndex + (endIndex-startIndex)/2;

        if(arr[mid] == key){
            return mid;
        }

        //checking if key exist in first left half of array or not
        // if it exist in first half then need to ignore second half
        if(arr[startIndex] <= arr[mid] && key <= arr[mid] && key >= arr[startIndex]){

           return binarySearch(arr,startIndex,mid-1,key);

            //arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]
        }else if( arr[mid] <= arr[endIndex] && key >= arr[mid] && key <= arr[endIndex]){

          return   binarySearch(arr,mid+1,endIndex,key);

        }else if(arr[endIndex] <= arr[mid]){

            return binarySearch(arr,mid+1,endIndex,key);
        } else if(arr[startIndex] >= arr[mid]){

           return binarySearch(arr,startIndex,mid-1,key);
        }
return -1;
    }

    public static void main(String[] args) {

        int[]arr = {3,4,5,6,1,2};

        System.out.println(new SearchInSortedAndRotatedArray().binarySearch(arr,0,arr.length-1,1));

    }
}
