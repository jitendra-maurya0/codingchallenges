package com.sample.test.array;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Given an array of integers, write a method to return the k most frequent elements.
 */
public class TopKFrequentElement {

    public List<Integer> getTopKFrequentEl(int[]arr,int k){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <arr.length ; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>>queue = new PriorityQueue<>(Comparator.comparing(Map.Entry::getValue));

        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            queue.add(entry);
            if(queue.size() >k){
                queue.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            result.add(queue.poll().getKey());
        }
        Collections.sort(result,Comparator.reverseOrder());

        return result;

    }

    public static void main(String[] args) {

        int[]arr = {1,1,1,1,3,3,3,4,2,4,6,6,6,6,10};

        TopKFrequentElement topKFrequentElement = new TopKFrequentElement();
        List<Integer> res1 =topKFrequentElement.getTopKFrequentEl(arr,2);
        List<Integer> res =topKFrequentElement.getTopKFrequentEl(arr,3);
        for(Integer i: res){
            System.out.print(" "+i);
        }

    }
}
