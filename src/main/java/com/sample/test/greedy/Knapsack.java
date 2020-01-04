package com.sample.test.greedy;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Knapsack {

    static int capacity = 41;
    static int getValue(String[]w,String[]v){
        Map<Integer,Integer> map =  new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<w.length;i++){
            map.put(Integer.parseInt(v[i]),Integer.parseInt(w[i]));
        }

        int currentCapacity = 0;
        int val = 0;
       for(Map.Entry<Integer,Integer>entry:map.entrySet()){
           if(currentCapacity <= capacity){
               currentCapacity += entry.getValue();
               val+=entry.getKey();
           }
       }
return val;
    }

    public static void main(String[] args) {
        String[] weight = "57 95 13 29 1 99 34 77 61 23 24 70 73 88 33 61 43 5 41 63 8 67 20 72 98 59 46 58 64 94 97 70 46 81 42 7 1 52 20 54 81 3 73 78 81 11 41 45 18 94 24 82 9 19 59 48 2 72".split(" ");
        String[] value = "83 84 85 76 13 87 2 23 33 82 79 100 88 85 91 78 83 44 4 50 11 68 90 88 73 83 46 16 7 35 76 31 40 49 65 2 18 47 55 38 75 58 86 77 96 94 82 92 10 86 54 49 65 44 77 22 81 52".split(" ");

        System.out.println(getValue(weight,value));
    }
}
