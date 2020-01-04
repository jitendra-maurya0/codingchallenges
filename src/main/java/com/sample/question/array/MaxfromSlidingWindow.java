package com.sample.question.array;

import java.util.*;

/**
 * given number and k size windows moving from left to right only k element is visible from array
 * find max element for every movement
 */
public class MaxfromSlidingWindow {

    /**
     * this algorithm uses heap to find max from sliding window
     * @param arr
     * @param windowSize
     * @return
     */
     List<Integer> getMaxElUsingHeap(int[]arr, int windowSize){

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <=arr.length-windowSize ; i++) {

            for (int j = i; j <i+windowSize ; j++) {
                priorityQueue.offer(arr[j]);
            }
            result.add(priorityQueue.poll());
            priorityQueue.clear();
        }
        return result;
    }


    /**
     * this algorithm uses deque data structure to compute max from sliding window
     * @param arr
     * @param windowSize
     * @return
     */
    ArrayDeque<Integer> getMaxElUsingDequue(int[]arr, int windowSize){

        ArrayDeque<Integer> result = new ArrayDeque<>();
        if(arr.length > 0){
            Deque<Integer> list = new LinkedList<>();

            if(arr.length < windowSize){
                return result;
            }

            int startIndex =0;

            for (int i = 0; i <windowSize ; i++) {

                while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]){
                    list.removeLast();
                }
                list.add(i);
                startIndex = i+1;

            }

            for (int i = startIndex; i <arr.length ; ++i) {

                result.add(arr[list.peek()]);

                // Removing all the elements indexes which are not in the current window
                while ((!list.isEmpty()) && list.peek() <= i - windowSize)
                    list.removeFirst();

                // Removing the smaller elements indexes which are not required
                while ((!list.isEmpty()) && arr[i] >= arr[list.peekLast()])
                    list.removeLast();

                // Adding newly picked element index
                list.addLast(i);
            }
            // Adding the max number of the current window in the result
            result.add(arr[list.peek()]);

            return result; // returning result
        } else
            return result;



    }

    public static void main(String[] args) {
        int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        MaxfromSlidingWindow maxfromSlidingWindow = new MaxfromSlidingWindow();
        System.out.println(maxfromSlidingWindow.getMaxElUsingHeap(a,k));
        System.out.println(maxfromSlidingWindow.getMaxElUsingDequue(a,k));

    }
}
