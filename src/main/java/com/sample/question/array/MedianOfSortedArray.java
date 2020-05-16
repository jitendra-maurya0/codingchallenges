package com.sample.question.array;

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

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    /*
    this algorithm uses binary search to find such partition where
    left half array is less than right half of array
    time complexity is O(log(m+n))
     */
    public  double getMedianOfSorted(int[]a,int[]b){

        if(a.length > b.length){
            return getMedianOfSorted(b,a);
        }
        int x = a.length;
        int y =b.length;
        int start =0;
        int end = x;
        while (start <= end){
            int partitionX = (start+end)/2;
            int partitionY = (x+y+1)/2-partitionX;

            int maxLeftX = partitionX == 0?Integer.MIN_VALUE:a[partitionX-1];
            int minRightX = partitionX == x?Integer.MAX_VALUE:a[partitionX];

            int maxLeftY = partitionY ==0?Integer.MIN_VALUE:b[partitionY-1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE:b[partitionY];
            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((x+y)%2 == 0){
                    return (double)Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY)/2;
                }else{
                    return Math.max(maxLeftX,maxLeftY);
                }
            }else if(maxLeftX > minRightY){
                end = partitionX-1;
            }else{
                start = partitionX+1;
            }
        }
           throw new IllegalArgumentException();
    }


    public static void main(String[] args) {
        int[]arr = {1,2,3};
        int[]arr1 = {5,6,8,10};
        MedianOfSortedArray medianOfSortedArray = new MedianOfSortedArray();
        int m = medianOfSortedArray.getMedian(arr1,arr);
        System.out.println(m);
        System.out.println(medianOfSortedArray.getMedianOfSorted(arr,arr1));
    }
}
