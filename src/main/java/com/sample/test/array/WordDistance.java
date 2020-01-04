package com.sample.test.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[]words) {
        map = new HashMap<>();
        for (int i = 0; i <words.length ; i++) {
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i],list);
            }
        }

    }

    public int getDistance(String word1,String word2){
        List<Integer>l1 = map.get(word1);
        List<Integer>l2 = map.get(word2);
        int result = Integer.MAX_VALUE;
        for (Integer i: l1){
            for (Integer i2:l2){
                result = Math.min(result,Math.abs(i-i2));
            }
        }
       return result;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        WordDistance wordDistance = new WordDistance(words);
        System.out.println(wordDistance.getDistance("makes","coding"));

    }
}
