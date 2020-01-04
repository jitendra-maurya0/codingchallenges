package com.sample.test.greedy;

import java.util.Arrays;

/**
 * you are given n activities with their start and finish times. Select the maximum number
 * of activities that can be performed by a single person, assuming that a person can only work
 * on a single activity at a time.
 * e.g
 *
 * Example 1 : Consider the following 3 activities sorted by
 * by finish time.
 *      start[]  =  {10, 12, 20};
 *      finish[] =  {20, 25, 30};
 * A person can perform at most two activities. The
 * maximum set of activities that can be executed
 * is {0, 2} [ These are indexes in start[] and
 * finish[] ]
 *
 */
public class ActivitySelection {

    static void printMaxActivity(int[]s,int[]f){
        Arrays.sort(f);
        int i ,j;

        i =0;
        System.out.print(i+" ");



        for ( j = 1; j <s.length ; j++) {
            if (s[j] >= f[i]) {
                System.out.print( j+" ");
                i =j;
            }
        }
    }

    public static void main(String[] args) {
        int[]s ={10,12,20};
        int[]f = {20,25,30};
        printMaxActivity(s,f);
    }
}
